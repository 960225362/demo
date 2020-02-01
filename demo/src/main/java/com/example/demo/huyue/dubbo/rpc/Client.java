package com.example.demo.huyue.dubbo.rpc;

/**
 * @author huyue01@sinovatech.com 2020/1/5 12:59
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(Hello.class);
        Hello hello= factory.getProxyObject();
        hello.say();

    }
}
