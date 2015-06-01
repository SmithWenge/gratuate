package com.team.graduate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.team.graduate.framework.RepositoryUtil;
import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;

@Repository
public class AdminLoginDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private RepositoryUtil<Log> repository;
	
	public Admin login(Admin admin) {
		String sql = "SELECT username FROM stu_graduate_loginuser where username=? and userpass=?";
		Object[] args = { admin.getUsername(), admin.getPassword() };
		try {
			return jdbcTemplate.queryForObject(sql, args, new AdminRowMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public List<Log> query4Log(Pageable pageable) {
		String sql = "SELECT logId, createDate, thread, `level`, class, message FROM stu_graduate_log4j";
		Object[] args = {};
		Page<Log> page = repository.select4Page(sql, pageable, args, new LogRowMapper());
		return page.getContent();
	}

//	public static void read4Page(Page<Log> page) {
//		String sql = "SELECT logId, createDate, thread, `level`, class, message FROM stu_graduate_log4j";
//
//		jdbc.query4Page(sql, new LogMapper(), page, 0);
//	}

	private class AdminRowMapper implements RowMapper<Admin> {
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			Admin admin = new Admin();
			admin.setUsername(rs.getString("username"));
			return admin;
		}
	}

	private class LogRowMapper implements ParameterizedRowMapper<Log> {

		public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
			Log log = new Log();
			log.setLogId(rs.getInt("logId"));
			log.setClazz(rs.getString("class"));
			log.setCreateDate(rs.getDate("createDate"));
			log.setLevel(rs.getString("level"));
			log.setMessage(rs.getString("message"));
			log.setThread(rs.getString("thread"));
			return log;
		}
	}
}
