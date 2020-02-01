package com.example.demo.huyue.design.jianzaozhe;

/**
 * @author huyue01@sinovatech.com 2019/11/2 12:03
 */
public class Client {
    public static void main(String[] args) {
        Builder builderA =  new ConcreteBuilder1();
        Builder builderB = new ConcreteBuilder2();
        Director director = new Director();

        director.construct(builderA);
        Product productA = builderA.getResult();
        productA.show();

        director.construct(builderB);
        Product productB = builderB.getResult();
        productB.show();
    }
}
