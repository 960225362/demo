package com.example.demo.huyue.design.interpreter;

/**
 * @author huyue01@sinovatech.com 2019/12/29 13:40
 */
public class ExpressionB implements Expression {
    @Override
    public void interpret(Context context) {
        System.out.println("ExpressionB:"+context.getName()+"|"+context.getAge());
    }
}
