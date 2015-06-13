package com.team.graduate.repository.impl;

import com.team.graduate.repository.LoginTimeRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/13.
 * Module : login time
 * Comments : login time repository
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Repository
public class LoginTimeRepositoryImpl implements LoginTimeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Timestamp time) {
        String sql = "INSERT INTO stu_graduate_logintime (loginTime) VALUES (?)";
        Object[] args = { time };

        jdbcTemplate.update(sql, args);
    }

    public Timestamp select() {
        String sql = "SELECT loginTime FROM stu_graduate_logintime WHERE id = (SELECT max(id) as id FROM stu_graduate_logintime)";
        Object[] args = { };

        try {
            return jdbcTemplate.queryForObject(sql, args, Timestamp.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
