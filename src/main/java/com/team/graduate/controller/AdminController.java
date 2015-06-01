package com.team.graduate.controller;

import com.google.code.kaptcha.Constants;
import com.team.graduate.common.util.MD5Util;
import com.team.graduate.model.Admin;
import com.team.graduate.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/1.
 * Module : admin
 * Comments : administrator
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    public static final String ADMIN_LOGIN_TAG = "adminLogin";
    @Autowired
    private AdminService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView adminLogin(Admin admin, HttpSession session, @RequestParam("authCode") String authCode) {
        if (!authCode.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString()))
            return new ModelAndView("redirect:/router/admin.action");

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        admin.setPassword(MD5Util.getMD5String(admin.getPassword()));
        Admin result = service.login(admin);

        if (null == result) return new ModelAndView("redirect:/router/admin.action");
        session.setAttribute(ADMIN_LOGIN_TAG, result);

        return new ModelAndView("admin/result/importIndex");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String adminLoginGet(Admin admin, HttpSession session) {
        return "redirect:/router/admin.action";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String adminLogout(HttpSession session) {
        session.removeAttribute(ADMIN_LOGIN_TAG);

        return "redirect:/router/admin.action";
    }
}
