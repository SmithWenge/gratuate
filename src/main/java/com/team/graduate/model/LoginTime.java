package com.team.graduate.model;

import org.joda.time.DateTime;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/13.
 * Module : login time
 * Comments : record administrator login time
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */
public class LoginTime {
    private int id;
    private DateTime time;

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public int getId() {

        return id;
    }

    public DateTime getTime() {
        return time;
    }
}
