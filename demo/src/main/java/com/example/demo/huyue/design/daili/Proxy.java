package com.example.demo.huyue.design.daili;

/**
 * @author huyue01@sinovatech.com 2019/10/4 12:27
 */
public class Proxy extends Subject {
    RealSubject realSubject;
    @Override
    public void request() {
        if (realSubject==null){
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
