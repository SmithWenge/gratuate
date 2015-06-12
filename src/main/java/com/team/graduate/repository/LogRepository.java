package com.team.graduate.repository;

import com.team.graduate.model.LogMessage;

import java.util.List;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/11.
 * Module : log
 * Comments : add log message support
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

public interface LogRepository {
    public void insert(LogMessage message);
    public List<LogMessage> selectAll();
}
