package com.team.graduate.service;

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
public interface LoginTimeService {
    void update(Timestamp time);
    Timestamp queryRecent();
}
