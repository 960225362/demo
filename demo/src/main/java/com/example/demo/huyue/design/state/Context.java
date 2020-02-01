package com.example.demo.huyue.design.state;

/**
 * @author huyue01@sinovatech.com 2019/11/10 12:18
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    void request(){
        state.handle(this);
    }
}
