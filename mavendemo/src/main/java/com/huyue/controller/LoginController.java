package com.huyue.controller;

import com.huyue.bean.User;
import com.huyue.common.base.BaseController;
import com.huyue.common.util.CacheUtil;
import com.huyue.service.UserService;
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
public class LoginController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("check")
    public ModelAndView check(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = super.createJsonView();
        String username = super.getParameter(request, "username");
        String password = super.getParameter(request, "password");
        String superUser = "admin";
        String superPwd = "123456";
        if (superUser.equals(username) && superPwd.equals(password)) {
            User user = new User();
            user.setName(superUser);
            user.setPassword(superPwd);
            request.getSession().setAttribute("user",user);
            view.addObject("result", 0);
        } else {
            view.addObject("result", 1);
            view.addObject("message", "登录名或密码不正确");
        }
        return view;

    }

    @RequestMapping("insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setName("nihao");
        user.setPhone("18355181775");
        userService.insert(user);
        return new ModelAndView();


    }
}
