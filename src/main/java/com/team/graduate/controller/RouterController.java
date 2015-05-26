package com.team.graduate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("search")
    public String routeToStuSearch() {
        return "stu/search";
    }
}
