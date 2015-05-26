package com.team.graduate.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;

public interface AdminLoginService {
	public Admin loginAdmin(Admin admin);
	public List<Log> getLogs(Admin admin, Pageable pageable);
	
	public Page<Log> readUsersWithPage(Pageable pageable);
	public boolean isLogin(Admin admin);
}
