package com.example.demo.huyue.design.visitor;

/**
 * @author huyue01@sinovatech.com 2020/1/1 12:28
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }
}
