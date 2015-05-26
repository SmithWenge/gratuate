package com.team.graduate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.graduate.common.AuthCodeGenerator;
import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

@Controller
@RequestMapping("/stu")
public class StuGraduateController {
	@Autowired
	private StuGraduateService service;

	@RequestMapping("/searchResult")
	public ModelAndView selectResult(@ModelAttribute StuGraduateInfo stu,
			HttpServletRequest request) {
		String authCode = request.getSession()
				.getAttribute(AuthCodeGenerator.AUTHENTICATION_CODE).toString();
		ModelAndView mav = new ModelAndView();
		if (authCode != null && authCode.equals(stu.getAuthCode())) {
			StuGraduateInfo stuInfo = service.selectStuGraduateInfo(stu);
			if (stuInfo != null) {
				mav.addObject("stu", stuInfo);
				mav.setViewName("stu/searchResult");

			} else {
				mav.setViewName("redirect:/error.jsp");
			}
		} else {
			StuGraduateInfo infoAuthCode = new StuGraduateInfo();
			infoAuthCode.setAuthCode(null);
			mav.addObject("stu", infoAuthCode);
			mav.setViewName("redirect:/authError.jsp");
			
		}
		return mav;
	}

	@RequestMapping("/authResult")
	public ModelAndView authResult(@ModelAttribute StuGraduateInfo stu,
			HttpServletRequest request) {
		String authCode = request.getSession()
				.getAttribute(AuthCodeGenerator.AUTHENTICATION_CODE).toString();
		ModelAndView mav = new ModelAndView();
		if (authCode != null && authCode.equals(stu.getAuthCode())) {
			StuGraduateInfo stuInfo = service.authStuGraduateInfo(stu);

			if (stuInfo != null) {
				mav.addObject("stu", stuInfo);
				mav.setViewName("stu/authResult");

			} else {
				mav.setViewName("redirect:/error.jsp");
			}
		} else {
			StuGraduateInfo infoAuthCode = new StuGraduateInfo();
			infoAuthCode.setAuthCode(null);
			mav.addObject("stu", infoAuthCode);
			mav.setViewName("redirect:/authError.jsp");
		}
		return mav;
	}
}
