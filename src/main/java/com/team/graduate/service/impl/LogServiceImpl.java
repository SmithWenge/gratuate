package com.team.graduate.service.impl;

import com.team.graduate.model.LogMessage;
import com.team.graduate.repository.LogRepository;
import com.team.graduate.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/12.
 * Module : log
 * Comments : log service impl
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository repository;

    public void addNewLog(LogMessage message) {
        repository.insert(message);
    }

    public List<LogMessage> listAll() {
        return repository.selectAll();
    }

    public int selectCount() {
        return repository.selectCount();
    }
}
