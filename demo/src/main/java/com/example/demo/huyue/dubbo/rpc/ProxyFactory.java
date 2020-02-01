package com.example.demo.huyue.dubbo.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huyue01@sinovatech.com 2020/1/5 12:55
 */
public class ProxyFactory implements InvocationHandler {
    private Class interfaceClass;

    public ProxyFactory(Class interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public <T> T getProxyObject(){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{interfaceClass},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        System.out.println("测试dubbo");
        System.out.println("测试dubbo代理类");
        return null;
    }
}
