package com.example.demo.huyue.design.mediator;

/**
 * @author huyue01@sinovatech.com 2019/12/21 12:59
 */
public abstract class AbstractClass {
    protected Mediator mediator;

    public AbstractClass(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String msg);

    public abstract void notify(String msg);
}
