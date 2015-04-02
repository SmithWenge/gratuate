package com.team.graduate.service;

import com.team.graduate.model.StuGraduateInfo;

public interface StuGraduateService {
	public StuGraduateInfo selectStuGraduateInfo(StuGraduateInfo stu);
	public StuGraduateInfo authStuGraduateInfo(StuGraduateInfo stu);
}
