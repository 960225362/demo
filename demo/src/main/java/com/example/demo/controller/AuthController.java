package com.example.demo.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

/**
 * @author huyue01@sinovatech.com 2020/1/29 21:44
 */
@Controller
@Api(value = "HomeController|主页控制器")
@Slf4j
public class AuthController {

    /**
     * 只有ONE才能访问
     * @return
     */
    @Secured("ROLE_ONE")
    @GetMapping("/one")
    public String one(){
        return "auth/one";
    }

    /**
     * 只有TWO才能访问
     * @return
     */
    @PreAuthorize("hasRole('TWO')")
    @GetMapping("/two")
    public String two(){
        return "auth/two";
    }

    /**
     * 只有THREE才能访问
     * @return
     */
    @RolesAllowed("THREE")
    @GetMapping("/three")
    public String three(){
        return "auth/three";
    }

}
