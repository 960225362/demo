package com.example.demo.huyue.design.beiwanglu;

/**
 * @author huyue01@sinovatech.com 2019/11/24 11:16
 */
public class Origination {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setMemento(Memento memento){
        state = memento.getState();
    }

    public void show(){
        System.out.println("=======state:"+state);
    }
}
