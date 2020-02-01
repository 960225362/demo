package com.example.demo.huyue.design.bridge;

/**
 * @author huyue01@sinovatech.com 2019/12/14 16:27
 */
public class Client {
    public static void main(String[] args) {
        Abstraction abstractionA = new RedinedAbstraction(new ImplementorA());
        Abstraction abstractionB = new RedinedAbstraction(new ImplementorB());

        abstractionA.operation();
        abstractionB.operation();
    }
}
