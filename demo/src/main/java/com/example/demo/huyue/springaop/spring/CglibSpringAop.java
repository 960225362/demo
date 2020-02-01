package com.example.demo.huyue.springaop.spring;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author huyue01@sinovatech.com 2019/3/3 15:11
 */
public class CglibSpringAop implements MethodInterceptor {
    private static  CglibSpringAop aop = new CglibSpringAop();

    public CglibSpringAop() {
    }

    private Enhancer enhancer = new Enhancer();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MonitorSession.start(method.getName());
        Object object = methodProxy.invokeSuper(o,objects);
        MonitorSession.end();
        return object;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> T){
        enhancer.setSuperclass(T);
        enhancer.setCallback(this);
        return (T) enhancer.create();

    }
}
