package com.example.demo.huyue.design.daili;

import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

/**
 * @author huyue01@sinovatech.com 2019/10/4 12:28
 */
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
