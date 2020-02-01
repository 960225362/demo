package com.example.demo.huyue.design.mediator;

/**
 * @author huyue01@sinovatech.com 2019/12/21 13:04
 */
public class ConcreteMediator implements Mediator {
    private AbstractClassA abstractClassA;
    private AbstractClassB abstractClassB;

    public void setAbstractClassA(AbstractClassA abstractClassA) {
        this.abstractClassA = abstractClassA;
    }

    public void setAbstractClassB(AbstractClassB abstractClassB) {
        this.abstractClassB = abstractClassB;
    }

    @Override
    public void send(String msg, AbstractClass abstractClass) {
        if (null != abstractClass) {
            if (null != abstractClassA && abstractClass == abstractClassA) {
                abstractClassA.notify(msg);
            }
            if (null != abstractClassB && abstractClass == abstractClassB) {
                abstractClass.notify(msg);
            }
        }
    }
}
