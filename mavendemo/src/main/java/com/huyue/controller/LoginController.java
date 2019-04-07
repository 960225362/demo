package com.huyue.controller;

import com.huyue.bean.User;
import com.huyue.common.util.CacheUtil;
import com.huyue.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huyue01@sinovatech.com 2019/3/17 15:05
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("check")
    public ModelAndView check(HttpServletRequest request,HttpServletResponse response){
        ModelAndView view = new ModelAndView("jsonView");
        System.out.println("开始塞入缓存数据");
        CacheUtil.setString("123","huyue");
        System.out.println(CacheUtil.getString("123"));
//        String username= request.getParameter("username");
//        String password= request.getParameter("password");
//        String superUser = "admin";
//        if (superUser.equals(username)){
//            view.addObject("result",0);
//        }else {
//            view.addObject("result",1);
//            view.addObject("message","登录名不正确");
//        }
        return view;

    }

    @RequestMapping("insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response){
         User user = new User();
        user.setName("huyue");
        user.setPhone("18355181775");
        userServiceImpl.insert(user);
        return new ModelAndView();


    }

    public static void main(String[] args) {

    }
}
