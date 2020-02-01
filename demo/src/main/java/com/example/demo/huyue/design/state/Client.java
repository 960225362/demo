package com.example.demo.huyue.design.state;

/**
 * @author huyue01@sinovatech.com 2019/11/10 12:23
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new StateA());
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
    }
}
