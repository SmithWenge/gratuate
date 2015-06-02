package com.team.graduate.service.impl;

import java.io.File;
import java.util.List;

import com.team.graduate.common.excel.ExcelConverter;
import com.team.graduate.common.excel.StuGraduateInfoExcelMapper;
import com.team.graduate.model.StuGraduateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team.graduate.dao.AdminLoginDaoImpl;
import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;
import com.team.graduate.service.AdminService;
import com.team.graduate.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository repository;
	@Autowired
	private ExcelConverter<StuGraduateInfo> converter;

	public Admin login(Admin admin) {

		return repository.select(admin);
	}

	public void importData(File file) {
		List<StuGraduateInfo> importStudents = converter.readFromExcel(file, 1, new StuGraduateInfoExcelMapper());

//		TODO if data is regal
		System.out.println();
	}


//	public Admin loginAdmin(Admin admin) {
//		if (admin != null) {
//			impl.login(admin);
//		}
//		return null;
//	}
//
//	public List<Log> getLogs(Admin admin, Pageable pageable){
//		if(impl.login(admin) != null){
//			return impl.query4Log(pageable);
//		}
//		return null;
//	}
//
//	public Page<Log> readUsersWithPage(Pageable pageable) {
//		if (!isLogin(admin)) return null;
//		return imp.selectWithPage(pageable);
//
//	}
//
//	public boolean isLogin(Admin admin) {
//		Admin login = impl.login(admin);
//
//        return login != null;
//	}
}