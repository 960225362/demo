package com.example.demo.huyue.design.zhizelian;

/**
 * @author huyue01@sinovatech.com 2019/12/20 20:11
 */
public class FirstManager extends Manager {
    public FirstManager(String name) {
        super(name);
    }

    @Override
    void handler(Integer integer) {
        System.out.println("我是一把手，处理所有的事情");
    }
}
