package com.team.graduate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;

@Repository
public class AdminLoginDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Admin login(Admin admin) {
		String sql = "SELECT username FROM stu_graduate_loginuser where username=? and userpass=?";
		Object[] args = {admin.getUsername(),admin.getUserpass()};
		try {
			return jdbcTemplate.queryForObject(sql, args, new AdminRowMapper());
		} catch (Exception e) {
			return null;
		}
	}
	public List<Log> query4Log() {
		String sql = "SELECT logId, createDate, thread, `level`, class, message FROM stu_graduate_log4j";
		return jdbcTemplate.query(sql, new LogRowMapper());
	}

	private class AdminRowMapper implements RowMapper<Admin> {
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			Admin admin = new Admin();
			admin.setUsername(rs.getString("username"));
			return admin;
		}
	}
	
	private class LogRowMapper implements RowMapper<Log> {

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
