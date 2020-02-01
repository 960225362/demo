package com.example.demo.huyue.dubbo.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;


/**
 * @author huyue01@sinovatech.com 2020/1/5 13:20
 */
public class myRPCBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    protected Class getBeanClass(Element element){
        return ReferenceBean.class;
    }

    public void doParse(Element element, BeanDefinitionBuilder bean){
        String interfaceClass = element.getAttribute("interface");
        if (StringUtils.hasText(interfaceClass)){
            bean.addPropertyValue("interfaceClass",interfaceClass);
        }

    }
}
