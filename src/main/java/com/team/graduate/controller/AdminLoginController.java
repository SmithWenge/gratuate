package com.team.graduate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.team.graduate.model.Admin;
import com.team.graduate.model.Log;
import com.team.graduate.service.AdminLoginService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	public static final String MODEL_ATTRIBUTE_USERS_PAGE = "page";
    private static final int DEFAULT_PAGE_SIZE = 5;
    
	@Autowired
	private AdminLoginService service;
	
	@RequestMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="/log")
	public ModelAndView adminCheck(@ModelAttribute("admin") Admin admin){
		Pageable pageable = new PageRequest(0, 5);
		List<Log> log= service.getLogs(admin, pageable);
		ModelAndView mav = new ModelAndView();
		if(log != null) {
			mav.addObject("log", log);
			mav.setViewName("admin/log");
		}else {
			mav.setViewName("redirect:/prompt/error");
		}
		return mav;
	}
	
	@ResponseBody
    @RequestMapping("/page")
    public Map<String, Page<Log>> adminToGetUserResultWithPage(@PageableDefault(value = DEFAULT_PAGE_SIZE)
                                                                    Pageable pageable) {
        Page<Log> page = service.readUsersWithPage(pageable);

        Map<String, Page<Log>> jsonMap = new HashMap<String, Page<Log>>();
        jsonMap.put(MODEL_ATTRIBUTE_USERS_PAGE, page);

        return jsonMap;
    }
}
