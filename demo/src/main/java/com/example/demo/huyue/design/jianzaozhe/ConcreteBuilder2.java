package com.example.demo.huyue.design.jianzaozhe;

/**
 * @author huyue01@sinovatech.com 2019/11/2 12:00
 */
public class ConcreteBuilder2 extends Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.addPart("部件X");
    }

    @Override
    public void buildPartB() {
        product.addPart("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
