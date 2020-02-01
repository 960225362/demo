package com.example.demo.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author huyue01@sinovatech.com 2020/1/29 21:26
 */
@RestController
@Api(value = "UserController|用户控制器")
@Slf4j
public class UserController {

    @GetMapping("/user1")
    public Object user1(Principal principal){
        return principal;
    }

    @GetMapping("/user2")
    public Object user2(Authentication authentication){
        return authentication;
    }

    @GetMapping("/user3")
    public Object user3(HttpServletRequest request){
        return request.getUserPrincipal();
    }
}
