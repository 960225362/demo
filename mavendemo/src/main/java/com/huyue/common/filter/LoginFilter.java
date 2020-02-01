package com.huyue.common.filter;

import com.huyue.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author huyue01@sinovatech.com 2019/4/14 16:01
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //获取请求地址
        String path = request.getRequestURI();

        String url = "/mavendemo/";
        String checkUrl = "/mavendemo/login/check.do";
        if (url.equals(path)||checkUrl.equals(path)) {
            filterChain.doFilter(request, response);
            return;
        }
        //判断是否登录，未登录跳转到登录界面
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(url);
        } else {
            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
