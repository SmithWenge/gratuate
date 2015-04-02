package com.team.graduate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.graduate.common.AuthCodeGenerator;
import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

@Controller
@RequestMapping("/stu")
public class StuGraduateController {
	@Autowired
	private StuGraduateService service;

	@ResponseBody
	@RequestMapping("/select")
	public Map<String, StuGraduateInfo> selectResult(@RequestBody StuGraduateInfo stu, HttpServletRequest request) {
		String authCode = request.getSession().getAttribute(AuthCodeGenerator.AUTHENTICATION_CODE).toString();
		Map<String, StuGraduateInfo> map = new HashMap<String, StuGraduateInfo>();
		if (authCode != null && authCode.equals(stu.getAuthCode())) {
			StuGraduateInfo stuInfo = service.selectStuGraduateInfo(stu);
			
			if (stuInfo != null) {
				map.put("stu", stuInfo);
			} else {
				map.put("stu", new StuGraduateInfo("null"));
			}
		} else {
			StuGraduateInfo infoAuthCode = new StuGraduateInfo();
			infoAuthCode.setAuthCode(null);
			
			map.put("stu", infoAuthCode);
		}
		
		return map;
	}

	@ResponseBody
	@RequestMapping("/auth")
	public Map<String, StuGraduateInfo> authResult(@RequestBody StuGraduateInfo stu, HttpServletRequest request) {
		String authCode = request.getSession().getAttribute(AuthCodeGenerator.AUTHENTICATION_CODE).toString();
		Map<String, StuGraduateInfo> map = new HashMap<String, StuGraduateInfo>();
		if (authCode != null && authCode.equals(stu.getAuthCode())) {
			StuGraduateInfo stuInfo = service.authStuGraduateInfo(stu);
			
			if (stuInfo != null) {
				map.put("stu", stuInfo);
			} else {
				map.put("stu", new StuGraduateInfo(null));
			}
		} else {
			StuGraduateInfo infoAuthCode = new StuGraduateInfo();
			infoAuthCode.setAuthCode(null);
			
			map.put("stu", infoAuthCode);
		}
		
		return map;
	}
}
