package com.team.graduate.service;

import com.team.graduate.model.StuGraduateInfo;

import java.util.List;

public interface StuGraduateService {
	public List<StuGraduateInfo> selectStuGraduateInfo(StuGraduateInfo stu);
	public StuGraduateInfo authStuGraduateInfo(StuGraduateInfo stu);
}
