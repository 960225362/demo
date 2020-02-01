package com.example.demo.huyue.design.beiwanglu;

/**
 * @author huyue01@sinovatech.com 2019/11/24 11:18
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
