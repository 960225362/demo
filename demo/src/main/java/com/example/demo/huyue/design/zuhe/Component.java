package com.example.demo.huyue.design.zuhe;

/**
 * @author huyue01@sinovatech.com 2019/11/30 11:07
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public Component() {
    }

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void showContent();
}
