package com.team.graduate.repository;

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
public interface LoginTimeRepository {
    void insert(Timestamp time);
    Timestamp select();
}
