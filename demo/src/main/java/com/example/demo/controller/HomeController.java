package com.example.demo.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huyue01@sinovatech.com 2020/1/29 16:26
 */
@Controller
@Api(value = "HomeController|主页控制器")
@Slf4j
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
