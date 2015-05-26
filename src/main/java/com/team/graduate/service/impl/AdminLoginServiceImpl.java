package com.team.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team.graduate.dao.AdminLoginDaoImpl;
import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;
import com.team.graduate.service.AdminLoginService;
import com.team.graduate.repository.AdminRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminLoginDaoImpl impl;
	@Autowired
	private AdminRepository imp;

	public Admin loginAdmin(Admin admin) {
		if (admin != null) {
			impl.login(admin);
		}
		return null;
	}

	public List<Log> getLogs(Admin admin, Pageable pageable){
		if(impl.login(admin) != null){
			return impl.query4Log(pageable);
		}
		return null;
	}

	public Page<Log> readUsersWithPage(Pageable pageable) {
//		if (!isLogin(admin)) return null;
		return imp.selectWithPage(pageable);
		
	}

	public boolean isLogin(Admin admin) {
		Admin login = impl.login(admin);

        return login != null;
	}
}