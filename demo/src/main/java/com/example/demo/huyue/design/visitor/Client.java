package com.example.demo.huyue.design.visitor;

/**
 * @author huyue01@sinovatech.com 2020/1/1 12:34
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();

        Element elementA = new ConcreteElementA();
        Element elementB = new ConcreteElementB();

        Visitor visitorA = new ConcreteVisitorA();
        Visitor visitorB = new ConcreteVisitorB();

        structure.add(elementA);
        structure.add(elementB);

        structure.accept(visitorA);
        structure.accept(visitorB);
    }
}
