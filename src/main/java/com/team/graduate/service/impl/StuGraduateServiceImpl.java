package com.team.graduate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.graduate.repository.impl.StuGraduateRepositoryImpl;
import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

import java.sql.Date;
import java.util.List;

@Service
public class StuGraduateServiceImpl implements StuGraduateService {
	@Autowired
	private StuGraduateRepositoryImpl impl;

	public List<StuGraduateInfo> selectStuGraduateInfo(StuGraduateInfo stu) {
		List<StuGraduateInfo> infos = impl.selectNameAndIdentificationNum(stu);
		
		return infos;
	}

	public StuGraduateInfo authStuGraduateInfo(StuGraduateInfo stu) {
		StuGraduateInfo info = impl.authNameAndDegreeNumAndPubDate(stu);
		
		return info;
	}

	public List<Date> getAllDate() {
		return impl.getDiffDate();
	}
}
