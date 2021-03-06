package com.team.graduate.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.team.graduate.model.StuGraduateInfo;

import com.team.graduate.model.Admin;

public interface AdminService {
	public Admin login(Admin admin);
	public Map<String, List<StuGraduateInfo>> importData(File file);

	boolean isRightImage(String idNum);

	void addNewStudent(StuGraduateInfo info);

	StuGraduateInfo queryKV(String key, String value);

	StuGraduateInfo query4Update(String stuId);

	StuGraduateInfo updateGraduate(StuGraduateInfo info);

	int queryAllCount();

	int updatePassword(Admin admin);
}
