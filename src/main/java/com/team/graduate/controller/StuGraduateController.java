package com.team.graduate.controller;

import javax.servlet.http.HttpServletRequest;

import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuGraduateController {
	@Autowired
	private StuGraduateService service;

	private static final String SEARCH_REDIRECT_LOCATION = "redirect:/router/search.action";

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute StuGraduateInfo stu,
							   HttpServletRequest request, @RequestParam("authCode") String code) {

		if (!(stu.isLegal() && code.length() == 4)) return new ModelAndView(SEARCH_REDIRECT_LOCATION);

		String authCode = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
		ModelAndView mav = new ModelAndView();

		if (authCode != null && authCode.equals(code)) {
			List<StuGraduateInfo> stuInfo = service.selectStuGraduateInfo(stu);
			if (stuInfo != null) {
				mav.addObject("stus", stuInfo);
				mav.addObject("stuName", stu.getStuName());
				mav.addObject("stuNameIdNum", stu.getStuIdentificationNum());
				mav.setViewName("stu/result/search");
			} else {
				mav.addObject("stu", stu);
				mav.setViewName("stu/error/search");
			}
		} else {
			mav.setViewName(SEARCH_REDIRECT_LOCATION);
		}

		return mav;
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String searchGet() {
		return SEARCH_REDIRECT_LOCATION;
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
