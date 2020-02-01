package com.example.demo.huyue.design.beiwanglu;

/**
 * @author huyue01@sinovatech.com 2019/11/24 11:12
 */
public class Client {
    public static void main(String[] args) {
        Origination origination = new Origination();
        origination.setState("ON");
        origination.show();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(origination.createMemento());

        origination.setState("OFF");
        origination.show();

        origination.setMemento(caretaker.getMemento());
        origination.show();
    }
}
