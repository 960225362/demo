package com.example.demo.huyue.command;

/**
 * @author huyue01@sinovatech.com 2019/12/15 12:00
 */
public class Client {
    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Receiver());
        Invoker invoker = new Invoker(command);
        invoker.execute();
    }
}
