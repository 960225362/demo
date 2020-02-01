package com.example.demo.huyue.command;

/**
 * @author huyue01@sinovatech.com 2019/12/15 11:56
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
