package com.example.demo.huyue.design.zhuangshi;

/**
 * @author huyue01@sinovatech.com 2019/10/3 17:36
 */
public class Client {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        DecoratorA decoratorA = new DecoratorA();
        DecoratorB decoratorB = new DecoratorB();
        decoratorA.setComponent(concreteComponent);
        decoratorB.setComponent(decoratorA);
        decoratorA.Operation();
        decoratorB.Operation();
    }
}
