package com.example.demo.huyue.design.guanchazhe;

/**
 * @author huyue01@sinovatech.com 2019/11/3 12:19
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.Attach(new ConcreteObserver(concreteSubject,"A"));
        concreteSubject.Attach(new ConcreteObserver(concreteSubject,"B"));
        concreteSubject.Attach(new ConcreteObserver(concreteSubject,"C"));

        concreteSubject.setState("停止");
        concreteSubject.notifyObserver();
    }
}
