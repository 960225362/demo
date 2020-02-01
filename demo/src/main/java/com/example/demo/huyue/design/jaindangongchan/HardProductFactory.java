package com.example.demo.huyue.design.jaindangongchan;

/**
 * @author huyue01@sinovatech.com 2019/10/5 15:11
 */
public class HardProductFactory implements IFactory {
    @Override
    public Product getProduct() {
        return new HardProduct();
    }
}
