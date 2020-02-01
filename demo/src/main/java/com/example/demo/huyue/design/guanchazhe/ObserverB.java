package com.example.demo.huyue.design.guanchazhe;

/**
 * @author huyue01@sinovatech.com 2019/11/3 12:01
 */
public class ObserverB implements Observer {
    @Override
    public void update() {
        System.out.println("接受到信息，改变自己的B状态");
    }
}
