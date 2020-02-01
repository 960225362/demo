package com.example.demo.huyue.design.zhizelian;

/**
 * @author huyue01@sinovatech.com 2019/12/20 20:19
 */
public class Client {
    public static void main(String[] args) {
        Manager first = new FirstManager("一把手");
        Manager second = new SecondManager("二把手");
        Manager third = new ThirdManager("三把手");

        second.setSuper(first);
        third.setSuper(second);

        System.out.println("----------------------");
        second.handler(2);
        System.out.println("----------------------");
        second.handler(1);
        System.out.println("----------------------");
        third.handler(3);
        System.out.println("----------------------");
        third.handler(2);
        System.out.println("----------------------");
        third.handler(1);
        System.out.println("----------------------");

    }
}
