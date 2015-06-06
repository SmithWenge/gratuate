package com.team.graduate.service.impl;

import com.team.graduate.repository.StuGraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

import java.sql.Date;
import java.util.List;

@Service
public class StuGraduateServiceImpl implements StuGraduateService {
	@Autowired
	private StuGraduateRepository impl;

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

	public boolean isExist(String key, String value) {
		return impl.selectKV(key, value) > 0 ? false : true;
	}
}
