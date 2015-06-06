package com.team.graduate.repository;

import com.team.graduate.model.StuGraduateInfo;

import java.sql.Date;
import java.util.List;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/5/27.
 * Module : Student
 * Comments : Student repository
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */
public interface StuGraduateRepository {
    public List<StuGraduateInfo> selectNameAndIdentificationNum(StuGraduateInfo info);
    public StuGraduateInfo authNameAndDegreeNumAndPubDate(StuGraduateInfo stu);
    public List<Date> getDiffDate();

    int selectKV(String key, String value);
}
