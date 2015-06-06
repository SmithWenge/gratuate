package com.team.graduate.service;

import com.team.graduate.model.StuGraduateInfo;

import java.sql.Date;
import java.util.List;

public interface StuGraduateService {
	public List<StuGraduateInfo> selectStuGraduateInfo(StuGraduateInfo stu);
	public StuGraduateInfo authStuGraduateInfo(StuGraduateInfo stu);
	public List<Date> getAllDate();

	boolean isExist(String key, String value);
}
