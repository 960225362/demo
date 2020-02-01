package com.example.demo.huyue.design.guanchazhe;

/**
 * @author huyue01@sinovatech.com 2019/11/3 12:13
 */
public class ConcreteObserver implements Observer {
    private String name;
    private String state;
    private ConcreteSubject concreteSubject;

    public ConcreteObserver( ConcreteSubject concreteSubject,String name) {
        this.concreteSubject = concreteSubject;
        this.name = name;
    }

    @Override
    public void update() {
        state = concreteSubject.getState();
        System.out.println("观察者"+name+"的新状态是"+state);
    }
}
