package com.team.graduate.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * CopyRight (c) 2015 : 56Team
 * Project :
 * Created by 2015/6/11.
 * Module :
 * Comments :
 * JDK Version :
 *
 * @Author : xfdheyqkf
 * Version :
 */
public class LogMessage {
    private String id;
    private String IPAddress;
    private String queryStuName;
    private String queryStuDegree;
    private String queryStuId;
    private Date queryStuDate;
    private String tag;
    private Timestamp time;
    private String okOrNot;

    public LogMessage(String ip, String stuName, String stuIdentificationNum, String tag) {
        this.queryStuName = stuName;
        this.queryStuId = stuIdentificationNum;
        this.IPAddress = ip;
        this.tag = tag;
        this.id = UUID.randomUUID().toString();
    }

    public LogMessage(String ip, String queryStuDegree, Date queryStuDate, String queryStuName, String tag) {
        this.IPAddress = ip;
        this.queryStuDegree = queryStuDegree;
        this.queryStuDate = queryStuDate;
        this.queryStuName = queryStuName;
        this.tag = tag;
        this.id = UUID.randomUUID().toString();
    }

    public LogMessage() {

    }

    public void setOkOrNot(String okOrNot) {
        this.okOrNot = okOrNot;
    }

    public String getOkOrNot() {

        return okOrNot;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTime() {

        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public void setQueryStuDate(Date queryStuDate) {
        this.queryStuDate = queryStuDate;
    }

    public Date getQueryStuDate() {

        return queryStuDate;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public void setQueryStuName(String queryStuName) {
        this.queryStuName = queryStuName;
    }

    public void setQueryStuDegree(String queryStuDegree) {
        this.queryStuDegree = queryStuDegree;
    }

    public void setQueryStuId(String queryStuId) {
        this.queryStuId = queryStuId;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIPAddress() {

        return IPAddress;
    }

    public String getQueryStuName() {
        return queryStuName;
    }

    public String getQueryStuDegree() {
        return queryStuDegree;
    }

    public String getQueryStuId() {
        return queryStuId;
    }

    public String getTag() {
        return tag;
    }
}
