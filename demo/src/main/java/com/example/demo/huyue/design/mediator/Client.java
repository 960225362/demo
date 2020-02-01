package com.example.demo.huyue.design.mediator;

/**
 * @author huyue01@sinovatech.com 2019/12/21 13:15
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        AbstractClassA abstractClassA = new AbstractClassA(mediator);
        AbstractClassB abstractClassB = new AbstractClassB(mediator);

        mediator.setAbstractClassA(abstractClassA);
        mediator.setAbstractClassB(abstractClassB);

        abstractClassA.send("做A应该做的事");
        abstractClassB.send("做A应该做的事");
    }
}
