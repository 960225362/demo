package com.example.demo.huyue.design.visitor;

/**
 * @author huyue01@sinovatech.com 2020/1/1 12:30
 */
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorA ConcreteElementA 被访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorA ConcreteElementB 被访问");
    }
}
