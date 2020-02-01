package com.example.demo.huyue.dubbo.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author huyue01@sinovatech.com 2020/1/5 13:18
 */
public class myRPCNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("reference",new myRPCBeanDefinitionParser());
    }
}
