package com.example.demo.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.utils.JwtUtil;
import com.example.demo.pojo.Jwt;
import com.example.demo.pojo.SysUser;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huyue01@sinovatech.com 2020/1/29 16:11
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        System.out.println("========登录成功========");
//        httpServletResponse.sendRedirect("/home");
        //获取登录成功信息
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        boolean loginBoolean = true;

        SysUser sysUser = (SysUser) authentication.getPrincipal();
        sysUser.setPassword(null);
        long now = System.currentTimeMillis();

        JSONObject payload = new JSONObject();
        payload.put("iss", "sys");//签发人
        payload.put("aud", sysUser.getUsername());//受众
        payload.put("exp", now + JwtUtil.EXPIRE_TIME);
        payload.put("nbf", now);//生效时间
        payload.put("iat", now);//签发时间
        payload.put("jti", sysUser.getId());//编号
        payload.put("sub", "TWT-TEST");//主题
        payload.put("user", sysUser);//用户对象

        try {
            httpServletResponse.setHeader(JwtUtil.HEADER_TOKEN_NAME, new Jwt(payload.toJSONString()).toString());
        } catch (Exception e) {
            loginBoolean = false;
        }

        if (loginBoolean){
            httpServletResponse.getWriter().write("{\"code\":\"200\",\"msg\":\"登录成功\"}");
        }else {
            httpServletResponse.getWriter().write("{\"code\":\"200\",\"msg\":\"登录失败\"}");
        }

    }
}
