package com.team.graduate.service;

import java.util.List;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;

public interface AdminLoginService {
	public Admin loginAdmin(Admin admin);
	public List<Log> queryLog(Admin admin);
}
