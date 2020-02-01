package com.example.demo.huyue.design.visitor;

/**
 * @author huyue01@sinovatech.com 2020/1/1 12:32
 */
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorB ConcreteElementA 被访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorB ConcreteElementB 被访问");
    }
}
