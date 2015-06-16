package com.team.graduate.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.team.graduate.common.excel.into.ExcelConverter;
import com.team.graduate.common.excel.into.StuGraduateInfoExcelMapper;
import com.team.graduate.controller.AdminController;
import com.team.graduate.model.StuGraduateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.graduate.model.Admin;
import com.team.graduate.service.AdminService;
import com.team.graduate.repository.AdminRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository repository;
	@Autowired
	private ExcelConverter<StuGraduateInfo> converter;

	public Admin login(Admin admin) {

		return repository.select(admin);
	}

	@Transactional
	public Map<String, List<StuGraduateInfo>> importData(File file) {
		List<StuGraduateInfo> importStudents = converter.readFromExcel(file, 1, new StuGraduateInfoExcelMapper());
		List<StuGraduateInfo> errorData = new ArrayList<StuGraduateInfo>();
		List<StuGraduateInfo> repeatData = new ArrayList<StuGraduateInfo>();
		List<StuGraduateInfo> rightData = new ArrayList<StuGraduateInfo>();

		for (StuGraduateInfo info : importStudents) {
			if (info.isLegalImportData()) {
				if (repository.selectDiff(info)) {
					repeatData.add(info);
				} else {
					repository.insert(info);
					rightData.add(info);
				}
			} else {
				errorData.add(info);
			}
		}

		Map<String, List<StuGraduateInfo>> map = new HashMap<String, List<StuGraduateInfo>>();

		if (errorData.size() > 0 || repeatData.size() > 0) {
			map.put(AdminController.IMPORT_DATA_ERROR_DATA_RESULT, errorData);
			map.put(AdminController.IMPORT_DATA_REPEAT_DATA_RESULT, repeatData);
		}

		map.put(AdminController.IMPORT_DATA_RIGHT_DATA_RESULT, rightData);

//		reduce heap size
		importStudents = null;
		rightData = null;
		errorData = null;
		repeatData = null;

		return map;
	}

	public boolean isRightImage(String idNum) {

		return repository.selectDiffImageName(idNum);
	}

	public void addNewStudent(StuGraduateInfo info) {
		repository.insert(info);
	}

	public StuGraduateInfo queryKV(String key, String value) {
		return repository.selectInfo(key, value);
	}

	public StuGraduateInfo query4Update(String stuId) {
		return repository.queryByStuId(stuId);
	}

	@Transactional
	public StuGraduateInfo updateGraduate(StuGraduateInfo info) {
		return repository.update(info);
	}

	public int queryAllCount() {
		return repository.selectCountTotal();
	}

	public int updatePassword(Admin admin) {
		return repository.updateAdminPassword(admin);
	}
}