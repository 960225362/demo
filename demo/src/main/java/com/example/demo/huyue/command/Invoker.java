package com.example.demo.huyue.command;

/**
 * @author huyue01@sinovatech.com 2019/12/15 11:59
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
