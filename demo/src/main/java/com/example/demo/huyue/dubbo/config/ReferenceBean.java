package com.example.demo.huyue.dubbo.config;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author huyue01@sinovatech.com 2020/1/5 13:07
 */
public class ReferenceBean<T> extends ReferenceConfig<T> implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return get();
    }

    @Override
    public Class<?> getObjectType() {
        return getInterfaceClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
