package com.team.graduate.service;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;
import com.team.graduate.model.Page;

public interface AdminLoginService {
	public Admin loginAdmin(Admin admin);
	public Page<Log> queryLog(Admin admin , Page<Log> page);
}
