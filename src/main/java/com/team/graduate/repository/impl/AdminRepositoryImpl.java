package com.team.graduate.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.team.graduate.framework.RepositoryUtil;
import com.team.graduate.model.Log;
import com.team.graduate.repository.AdminRepository;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    private RepositoryUtil<Log> repository;

    public Page<Log> selectWithPage(Pageable pageable) {
        String sql = "SELECT logId, createDate, thread, `level`, class, message FROM stu_graduate_log4j";
        Object[] args = {};
        Page<Log> page = repository.select4Page(sql, pageable, args, new LogRowMapperParam());

        return page;
    }

    private class LogRowMapperParam implements ParameterizedRowMapper<Log> {

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
