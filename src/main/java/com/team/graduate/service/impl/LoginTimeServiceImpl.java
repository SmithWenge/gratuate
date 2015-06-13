package com.team.graduate.service.impl;

import com.team.graduate.repository.LoginTimeRepository;
import com.team.graduate.service.LoginTimeService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/13.
 * Module : login time
 * Comments : login time service
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Service
public class LoginTimeServiceImpl implements LoginTimeService {
    @Autowired
    private LoginTimeRepository repository;

    public void update(Timestamp time) {
        repository.insert(time);
    }

    public Timestamp queryRecent() {
        return repository.select();
    }
}
