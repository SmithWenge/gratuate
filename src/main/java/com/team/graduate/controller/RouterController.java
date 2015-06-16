package com.team.graduate.controller;

import com.google.code.kaptcha.Constants;
import com.team.graduate.service.StuGraduateService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/5/26.
 * Module : route
 * Comments : route the url
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */
@Controller
@RequestMapping("/router")
public class RouterController {
    public static final String ADMIN_LOGIN = "admin/login";
    @Autowired
    ServletContext context;

    @Autowired
    private StuGraduateService stuGraduateService;

    private static final String VALIDATE_CODE = "validateCode";

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String routeToStuSearch() {
        return "stu/search";
    }

    @ResponseBody
    @RequestMapping(value = "/validateCode", method = RequestMethod.POST)
    public boolean validateCode(HttpServletRequest request,
                                            @RequestParam("authCode") String authCode) {

        return request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString().equals(authCode);
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    public ModelAndView routeToStuAuth() {
        List<Date> dates =  stuGraduateService.getAllDate();

        return new ModelAndView("stu/authentication", "dates", dates);
    }

    @RequestMapping("/photo/{name}")
    public void photo(HttpServletResponse response, HttpServletRequest request,
                      @PathVariable("name") String name) throws IOException {
        response.setContentType("image/jpeg");
        InputStream in = context.getResourceAsStream("/WEB-INF/images/" + name + ".jpg");

        if (in == null) {
            in = context.getResourceAsStream("/WEB-INF/images/default.jpg");
        }

        IOUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping("/admin")
    public String admin(HttpSession session) {
        if (null != session.getAttribute(AdminController.ADMIN_LOGIN_TAG)) {
            return "admin/result/importIndex";
        }

        return ADMIN_LOGIN;
    }

    @RequestMapping("/image")
    public String image(HttpSession session) {
        if (null != session.getAttribute(AdminController.ADMIN_LOGIN_TAG)) {
            return "admin/image/import";
        }

        return ADMIN_LOGIN;
    }

    @RequestMapping("/single")
     public String single(HttpSession session) {
        if (null != session.getAttribute(AdminController.ADMIN_LOGIN_TAG)) {
            return "admin/single/index";
        }

        return ADMIN_LOGIN;
    }

    @RequestMapping(value = "/single/add", method = RequestMethod.GET)
    public String singleAdd(HttpServletRequest request) {
        if (null == request.getSession().getAttribute(AdminController.ADMIN_LOGIN_TAG)) {
            return ADMIN_LOGIN;
        } else {
            return "admin/single/add";
        }
    }

    @RequestMapping(value = "/log/index")
    public String logQuery(HttpServletRequest request) {
        if (null == request.getSession().getAttribute(AdminController.ADMIN_LOGIN_TAG)) {
            return ADMIN_LOGIN;
        } else {
            return "admin/log/logIndex";
        }
    }

    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String passwordChange(HttpServletRequest request) {
        if (null == request.getSession().getAttribute(AdminController.ADMIN_LOGIN_TAG)) {
            return ADMIN_LOGIN;
        } else {
            return "admin/password/change";
        }
    }
}
