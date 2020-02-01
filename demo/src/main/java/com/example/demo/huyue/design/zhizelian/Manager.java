package com.example.demo.huyue.design.zhizelian;

/**
 * @author huyue01@sinovatech.com 2019/12/20 20:07
 */
public abstract class Manager {

    private String name;

    protected Manager superManager;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuper(Manager superManager) {
        this.superManager = superManager;
    }


    abstract void handler(Integer integer);
}
