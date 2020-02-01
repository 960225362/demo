package com.example.demo.controller;

import com.example.demo.service.HystrixServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huyue01@sinovatech.com 2019/9/14 18:05
 */

@RequestMapping
@RestController("/hystrix")
@Api(value = "HystrixController|测试Hystrix框架")
@Slf4j
public class HystrixController {

    @Autowired
    private HystrixServiceImpl hystrixService;

    @RequestMapping(value = "testHystrix",method = RequestMethod.GET)
    @ApiOperation(value="测试hystrix", notes="test",tags = "shanshanlaichi")
    public String testHystrix(){
        log.info("============================>测试hystrix");
        for (int i = 0; i <50 ; i++) {

            hystrixService.testHystrix();
        }

        return "111";
    }




}
