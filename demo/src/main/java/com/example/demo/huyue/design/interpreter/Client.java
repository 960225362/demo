package com.example.demo.huyue.design.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyue01@sinovatech.com 2019/12/29 13:41
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setName("大宗师");
        context.setAge(100);

        List<Expression> list = new ArrayList<>();
        list.add(new ExpressionA());
        list.add(new ExpressionB());

        list.forEach(l->l.interpret(context));

    }
}
