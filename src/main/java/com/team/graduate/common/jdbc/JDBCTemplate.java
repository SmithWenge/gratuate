package com.team.graduate.common.jdbc;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.team.graduate.common.DataMapper;
import com.team.graduate.model.Page;


public class JDBCTemplate<T> {
	private DataSource dataSource = null; 
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//effective
	public int updateWithParams(String sql, Object[] objs) {
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			pstmt.clearParameters();
			pstmt = conn.prepareStatement(sql);
			ParameterMetaData meta = pstmt.getParameterMetaData();
			int count = meta.getParameterCount();
			for(int i=1; i<=count; i++) {	
				pstmt.setObject(i, objs[i-1]);	
			}
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
		
		return -1;
	}
	
	//effective
	public T queryWithParams(String sql, Object[] objs, DataMapper<T> mapper){
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			if(pstmt != null){
				pstmt.clearParameters();
			}
			ParameterMetaData meta = pstmt.getParameterMetaData();
			int count = meta.getParameterCount();
			
			for(int i=0; i < count; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return mapper.mapRecord(rs, 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
		return null;
	}
	
	//effective
	public List<T> queryWithParams(String sql, Object[] objs, DataMapper<T> mapper, int num){
		List<T> list = null;
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(pstmt != null){
				pstmt.clearParameters();
			}
			ParameterMetaData meta = pstmt.getParameterMetaData();
			int count = meta.getParameterCount();
			for(int i=0; i < count; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			
			ResultSet rs = pstmt.executeQuery(sql);
			list = new ArrayList<T>();
			while (rs.next()) {
				list.add(mapper.mapRecord(rs, num));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
		return list;
	}
		
	
	public int update(String sql) {
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
		
		return -1;
	}
	
	public void updateBatch(String[] sqls) {
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			stmt = conn.createStatement();
			for(String sql : sqls) {
				stmt.addBatch(sql);
			}
			
			conn.setAutoCommit(false);
			stmt.executeBatch();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
	}
	
	public T query(String sql, DataMapper<T> mapper) {
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				return mapper.mapRecord(rs, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release();
		}
		
		return null;
	}
	
	public List<T> query(String sql, DataMapper<T> mapper, int num) {
		List<T> list = null;
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			list = new ArrayList<T>();
			while(rs.next()) {
				list.add(mapper.mapRecord(rs, num));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
		
		return list;
	}
	
	public boolean queryUnique(String sql) {
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
		
		return false;
	}
	
	public void query4Page(String sql, DataMapper<T> mapper, Page<T> page, int num) {
		page.setTotalCount(query4TotalCount(sql));
		StringBuffer buffer = new StringBuffer(sql);
		int startCursor = page.getPageNum() * page.getPageSize();
		int endCursor = page.getPageSize();
		
		buffer.append(" ORDER BY ").append(page.getOrderBy()).append(" LIMIT ").append(startCursor).append(", ").append(endCursor);
		page.setResult(query(buffer.toString(), mapper, num));
	}
	
	public int query4TotalCount(String sql) {
		int tmp = 0;
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			StringBuffer buffer = new StringBuffer("SELECT count(1) as count FROM (");
			buffer.append(sql).append(" ) AS T1");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(buffer.toString());
			while (rs.next()) {
				tmp = Integer.valueOf(rs.getString("count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	//准备语句批量更新
	public void insertParams(String sql, List<Object[]> list) {
		try {
			if (null == conn || conn.isClosed()) 
				conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			
			for (Object[] args : list) {
				pstmt.clearParameters();

				ParameterMetaData meta = pstmt.getParameterMetaData();
				int count = meta.getParameterCount();
				for(int i=0; i < count; i++) {
					pstmt.setObject(i + 1, args[i]);
				}
				
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release();
		}
	}
	
	public void release() {
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(null != pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pstmt = null;
		}
		if(null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}

