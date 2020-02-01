package com.example.demo.huyue.design.mediator;

/**
 * @author huyue01@sinovatech.com 2019/12/21 13:01
 */
public class AbstractClassB extends AbstractClass {
    public AbstractClassB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String msg) {
        mediator.send(msg, this);
    }

    @Override
    public void notify(String msg) {
        System.out.println("AbstractClassB======="+msg);
    }
}
