package com.example.demo.huyue.design.zhuangshi;

/**
 * @author huyue01@sinovatech.com 2019/10/3 17:27
 */
public class DecoratorA extends Decorator {
    private String string;

    @Override
    public void Operation() {
        super.Operation();
        System.out.println("DecoratorA 独有的string"+string);
    }
}
