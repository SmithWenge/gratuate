package com.team.graduate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.graduate.dao.StuGraduateDaoImpl;
import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

@Service
public class StuGraduateServiceImpl implements StuGraduateService {
	@Autowired
	private StuGraduateDaoImpl impl;

	public StuGraduateInfo selectStuGraduateInfo(StuGraduateInfo stu) {
		StuGraduateInfo info = impl.selectNameAndIdentificationNum(stu);
		
		return info;
	}

	public StuGraduateInfo authStuGraduateInfo(StuGraduateInfo stu) {
		StuGraduateInfo info = impl.authNameAndDegreeNumandPubDate(stu);
		
		return info;
	}

}
