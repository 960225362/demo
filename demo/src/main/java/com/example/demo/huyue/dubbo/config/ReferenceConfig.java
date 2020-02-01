package com.example.demo.huyue.dubbo.config;

import com.example.demo.huyue.dubbo.rpc.ProxyFactory;

/**
 * @author huyue01@sinovatech.com 2020/1/5 13:08
 */
public class ReferenceConfig<T> {
    private Class<?> interfaceClass;

    /**
     * 接口代理类引用
     */
    private transient volatile T ref;

    public synchronized T get() {
        if (null == ref) {
            init();
        }
        return ref;
    }

    private void init() {
        ref = new ProxyFactory(interfaceClass).getProxyObject();
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}
