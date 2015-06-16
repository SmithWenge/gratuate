package com.team.graduate.controller;

import com.google.code.kaptcha.Constants;
import com.team.graduate.common.util.MD5Util;
import com.team.graduate.model.Admin;
import com.team.graduate.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/6/16.
 * Module : password
 * Comments : password setting
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */

@Controller
@RequestMapping("/password")
public class PasswordController {
    @Autowired
    private AdminService service;

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public ModelAndView changePassword(@RequestParam("password") String password,
                                       @RequestParam("newpassword") String newpassword,
                                       @RequestParam("repassword") String repassword,
                                       @RequestParam("authCode") String authCode, HttpSession session) {
        Object sessionCode = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (sessionCode == null ) {
            return new ModelAndView(AdminController.REDIRECT_ROUTER_ADMIN_ACTION);
        }

        if (!authCode.equals(sessionCode.toString()))
            return new ModelAndView(AdminController.REDIRECT_ROUTER_ADMIN_ACTION);

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (null == session.getAttribute(AdminController.ADMIN_LOGIN_TAG))
            return new ModelAndView(AdminController.REDIRECT_ROUTER_ADMIN_ACTION);

        if (!newpassword.equals(repassword))
            return new ModelAndView("redirect:/router/password.action");

        Admin admin = new Admin();
        admin.setUsername(((Admin) session.getAttribute(AdminController.ADMIN_LOGIN_TAG)).getUsername());
        admin.setPassword(MD5Util.getMD5String(password));

        Admin result = service.login(admin);

        if (result == null) {
            return new ModelAndView("redirect:/router/password.action");
        }

        admin.setPassword(MD5Util.getMD5String(newpassword));

        service.updatePassword(admin);

        session.removeAttribute(AdminController.ADMIN_LOGIN_TAG);

        return new ModelAndView(AdminController.REDIRECT_ROUTER_ADMIN_ACTION);
    }
}
