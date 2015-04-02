package com.team.graduate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/route")
public class RouteController {

	@RequestMapping("error")
	public String redirectErrorPage() {
		return "redirect:/prompt/error.jsp";
	}
	@RequestMapping("errorAuth")
	public String redirectAuthErrorPage() {
		return "redirect:/prompt/errorAuth.jsp";
	}
}
