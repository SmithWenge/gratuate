package com.team.graduate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;
import com.team.graduate.service.AdminLoginService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	@Autowired
	private AdminLoginService service;
	
	@RequestMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="/log")
	public ModelAndView adminCheck(@ModelAttribute("admin") Admin admin){
		List<Log> logs = service.queryLog(admin);
		ModelAndView mav = new ModelAndView();
		if(logs != null) {
			mav.addObject("logs", logs);
			mav.setViewName("admin/log");
		}else {
			mav.setViewName("redirect:/prompt/error");
		}
		return mav;
	}
}
