package com.team.graduate.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.team.graduate.model.StuGraduateInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;

public interface AdminService {
	public Admin login(Admin admin);
	public Map<String, List<StuGraduateInfo>> importData(File file);
}
