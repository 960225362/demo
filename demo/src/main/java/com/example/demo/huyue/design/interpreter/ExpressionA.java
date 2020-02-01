package com.example.demo.huyue.design.interpreter;

/**
 * @author huyue01@sinovatech.com 2019/12/29 13:39
 */
public class ExpressionA implements Expression {

    @Override
    public void interpret(Context context) {
        System.out.println("ExpressionA:"+context.getName()+"|"+context.getAge());
    }
}
