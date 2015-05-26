package com.team.graduate.controller;

import javax.servlet.http.HttpServletRequest;

import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

@Controller
@RequestMapping("/stu")
public class StuGraduateController {
	@Autowired
	private StuGraduateService service;

	@RequestMapping("/search")
	public ModelAndView selectResult(@ModelAttribute StuGraduateInfo stu,
			HttpServletRequest request, @RequestParam("authCode") String code) {

		String authCode = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
		ModelAndView mav = new ModelAndView();

		if (authCode != null && authCode.equals(code)) {
			StuGraduateInfo stuInfo = service.selectStuGraduateInfo(stu);
			if (stuInfo != null) {
				mav.addObject("stu", stuInfo);
				mav.setViewName("stu/result/search");
			} else {
				mav.addObject("stu", stu);
				mav.setViewName("stu/error/search");
			}
		} else {
			mav.setViewName("redirect:/router/search.action");
		}

		return mav;
	}

	@RequestMapping("/auth")
	public ModelAndView authResult(@ModelAttribute StuGraduateInfo stu,
			HttpServletRequest request, @RequestParam("authCode") String code) {
		String authCode = request.getSession()
				.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
		ModelAndView mav = new ModelAndView();
		if (authCode != null && authCode.equals(code)) {
			StuGraduateInfo stuInfo = service.authStuGraduateInfo(stu);

			if (stuInfo != null) {
				mav.addObject("stu", stuInfo);
				mav.setViewName("stu/authResult");

			} else {
				mav.setViewName("redirect:/error.jsp");
			}
		} else {
			StuGraduateInfo infoAuthCode = new StuGraduateInfo();
//			infoAuthCode.setAuthCode(null);
			mav.addObject("stu", infoAuthCode);
			mav.setViewName("redirect:/authError.jsp");
		}
		return mav;
	}
}
