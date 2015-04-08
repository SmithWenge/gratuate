package com.team.graduate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.graduate.dao.AdminLoginDaoImpl;
import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;
import com.team.graduate.model.Page;
import com.team.graduate.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminLoginDaoImpl impl;

	public Admin loginAdmin(Admin admin) {
		if (admin != null) {
			impl.login(admin);
		}
		return null;
	}

	public Page<Log> queryLog(Admin admin, Page<Log> page) {
		if(impl.login(admin) != null){
			AdminLoginDaoImpl.read4Page(page);
		}
		return null;
	}
}