package com.team.graduate.controller;

import com.google.code.kaptcha.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    private static final String VALIDATE_CODE = "validateCode";

    @RequestMapping("/search")
    public String routeToStuSearch() {
        return "stu/search";
    }

    @ResponseBody
    @RequestMapping(value = "/validateCode", method = RequestMethod.POST)
    public boolean validateCode(HttpServletRequest request,
                                            @RequestParam("authCode") String authCode) {

        return request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString().equals(authCode);
    }
}
