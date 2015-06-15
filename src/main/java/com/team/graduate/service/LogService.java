package com.team.graduate.service;

import com.team.graduate.model.LogMessage;

import java.util.List;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/12.
 * Module : log
 * Comments : log service
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */
public interface LogService {
    void addNewLog(LogMessage message);
    List<LogMessage> listAll();
    int selectCount();
}
