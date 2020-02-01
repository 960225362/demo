package com.example.demo.huyue.design.jianzaozhe;

/**
 * @author huyue01@sinovatech.com 2019/11/2 11:58
 */
public class ConcreteBuilder1 extends Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.addPart("部件A");
    }

    @Override
    public void buildPartB() {
        product.addPart("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
