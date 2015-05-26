package com.team.graduate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("select")
	public String redirectErrorPage() {
		return "redirect:/prompt/search.jsp";
	}
	@RequestMapping("auth")
	public String redirectAuthErrorPage() {
		return "redirect:/prompt/identity.jsp";
	}
}
