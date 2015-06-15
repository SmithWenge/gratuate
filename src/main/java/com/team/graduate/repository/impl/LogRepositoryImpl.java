package com.team.graduate.repository.impl;

import com.team.graduate.model.LogMessage;
import com.team.graduate.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/12.
 * Module : log
 * Comments : log repository
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Repository
public class LogRepositoryImpl implements LogRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(LogMessage message) {
        String sql = "INSERT INTO stu_graduate_log (id, IPAddress, queryStuName, queryStuDegree, queryStuId, queryStuDate, tag, okOrNot) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = { message.getId(), message.getIPAddress(), message.getQueryStuName(), message.getQueryStuDegree(),
                message.getQueryStuId(), message.getQueryStuDate(), message.getTag(), message.getOkOrNot() };

        jdbcTemplate.update(sql, args);
    }

    public List<LogMessage> selectAll() {
        String sql = "SELECT id, IPAddress, queryStuName, queryStuDegree, queryStuId, queryStuDate, tag, `time`, okOrNot FROM stu_graduate_log  ORDER BY `time` DESC LIMIT 0,10";
        Object[] args = { };

        return jdbcTemplate.query(sql, args, new LogMessageRowMapper());
    }

    public int selectCount() {
        String sql = "SELECT count(1) as total FROM graduate.stu_graduate_log";
        Object[] args = { };

        return jdbcTemplate.queryForObject(sql, args, Integer.class);
    }

    private class LogMessageRowMapper implements ParameterizedRowMapper<LogMessage> {

        public LogMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
            LogMessage message = new LogMessage();

            message.setId(rs.getString("id"));
            message.setIPAddress(rs.getString("IPAddress"));
            message.setQueryStuName(rs.getString("queryStuName"));
            message.setQueryStuDegree(rs.getString("queryStuDegree"));
            message.setQueryStuId(rs.getString("queryStuId"));
            message.setQueryStuDate(rs.getDate("queryStuDate"));
            message.setTag(rs.getString("tag"));
            message.setTime(rs.getTimestamp("time"));
            message.setOkOrNot(rs.getString("okOrNot"));

            return message;
        }
    }
}
