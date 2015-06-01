package com.team.graduate.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;

public interface AdminService {
	public Admin login(Admin admin);
}
