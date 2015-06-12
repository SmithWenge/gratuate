package com.team.graduate.controller;

import javax.servlet.http.HttpServletRequest;

import com.google.code.kaptcha.Constants;
import com.team.graduate.common.constant.WebConstant;
import com.team.graduate.model.LogMessage;
import com.team.graduate.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.StuGraduateService;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuGraduateController {
	@Autowired
	private StuGraduateService service;
	@Autowired
	private LogService logService;

	private static final String SEARCH_REDIRECT_LOCATION = "redirect:/router/search.action";
	private static final String Authentication_REDIRECT_LOCATION ="redirect:/router/authentication.action";
	private static final Logger LOGGER = LoggerFactory.getLogger(StuGraduateController.class);

	private static final String STUDENT_SEARCH_TAG = "QUERY";
	private static final String STUDENT_AUTHENTICATION_TAG = "AUTHENTICATION";
	private static final String STUDENT_IS_OK = "OK";
	private static final String STUDENT_IS_NOT_OK = "NOT OK";

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute StuGraduateInfo stu,
							   HttpServletRequest request, @RequestParam("authCode") String code) {

		if (!(stu.isLegal() && code.length() == 4)) return new ModelAndView(SEARCH_REDIRECT_LOCATION);

		String authCode = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
		ModelAndView mav = new ModelAndView();

		if (authCode != null && authCode.equals(code)) {
//			reset key
			request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, null);

			List<StuGraduateInfo> stuInfo = service.selectStuGraduateInfo(stu);
			LogMessage message = new LogMessage( request.getRemoteAddr(), stu.getStuName(),
					stu.getStuIdentificationNum(), STUDENT_SEARCH_TAG);

			if (stuInfo != null && stuInfo.size() > 0) {

				message.setOkOrNot(STUDENT_IS_OK);
				logService.addNewLog(message);

				LOGGER.info("The student QUERY SUCCESS, the name is {} and the id is {}.",
						stu.getStuName(), stu.getStuIdentificationNum());

				mav.addObject("stus", stuInfo);
				mav.addObject("stuName", stu.getStuName());
				mav.addObject("stuNameIdNum", stu.getStuIdentificationNum());
				mav.setViewName("stu/result/search");
			} else {

				message.setOkOrNot(STUDENT_IS_NOT_OK);
				logService.addNewLog(message);

				mav.addObject("stu", stu);
				mav.setViewName("stu/error/search");
			}
		} else {
			LOGGER.info("The student QUERY FAILURE, NO STUDENT, the name is {} and the id is {}.",
					stu.getStuName(), stu.getStuIdentificationNum());

			mav.setViewName(SEARCH_REDIRECT_LOCATION);
		}

		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGet() {
		return SEARCH_REDIRECT_LOCATION;
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public ModelAndView authentication(@ModelAttribute StuGraduateInfo stu,
									   HttpServletRequest request, @RequestParam("authCode") String code) {
		if (!stu.isAuthenticationLegal()) return new ModelAndView(Authentication_REDIRECT_LOCATION);

		String authCode = request.getSession()
				.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();

		ModelAndView mav = new ModelAndView();
		LogMessage message = new LogMessage(request.getRemoteAddr(), stu.getStuMajorDegreeCertNum(),
				stu.getStuPublicationDate(), stu.getStuName(), STUDENT_AUTHENTICATION_TAG);

		if (authCode != null && authCode.equals(code)) {
//			reset key
			request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, null);
			StuGraduateInfo stuInfo = service.authStuGraduateInfo(stu);

			if (stuInfo != null) {

				message.setOkOrNot(STUDENT_IS_OK);
				logService.addNewLog(message);

				LOGGER.info("The student AUTHENTICATION SUCCESS, the name is {} and the Degree Number is {} and the Publication Date is {}.",
						stu.getStuName(), stu.getStuMajorDegreeCertNum(), stu.getStuPublicationDate());

				mav.addObject("stu", stuInfo);

				mav.setViewName("stu/result/authentication");
			} else {

				message.setOkOrNot(STUDENT_IS_NOT_OK);
				logService.addNewLog(message);

				LOGGER.info("The student AUTHENTICATION FAILURE, the name is {} and the Degree Number is {} and the Publication Date is {}.",
						stu.getStuName(), stu.getStuMajorDegreeCertNum(), stu.getStuPublicationDate());
				mav.addObject("stu", stu);
				mav.setViewName("stu/error/authentication");
			}
		} else {
			return new ModelAndView(Authentication_REDIRECT_LOCATION);
		}

		return mav;
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
	public String authenticationGet() {
		return "stu/authentication";
	}

	@ResponseBody
	@RequestMapping("/isStuNumberExist")
	public boolean isStuNumberExist(@RequestParam("stuNumber") String stuNumber) {
		return  service.isExist(WebConstant.STU_NUMBER, stuNumber);
	}

	@ResponseBody
	@RequestMapping("/isStuGraduationCardNumExist")
	public boolean isStuGraduationCardNumExist(@RequestParam("stuGraduationCardNum") String stuGraduationCardNum) {
		return  service.isExist(WebConstant.STU_GRADUATION_CARD_NUM, stuGraduationCardNum);
	}

	@ResponseBody
	@RequestMapping("/isStuMajorDegreeCertNumExist")
	public boolean isStuMajorDegreeCertNumExist(@RequestParam("stuMajorDegreeCertNum") String stuMajorDegreeCertNum) {
		return  service.isExist(WebConstant.STU_MAJOR_DEGREE_CERT_NUM, stuMajorDegreeCertNum);
	}

	@ResponseBody
	@RequestMapping("/isStuIdentificationNumExist")
	public boolean isStuIdentificationNumExist(@RequestParam("stuIdentificationNum") String stuIdentificationNum) {
		return  service.isExist(WebConstant.STU_IDENTIFICATION_NUM, stuIdentificationNum);
	}
}
