package com.example.demo.huyue.design.state;

/**
 * @author huyue01@sinovatech.com 2019/11/10 12:22
 */
public class StateB implements State {
    @Override
    public void handle(Context context) {
        context.setState(new StateA());
        System.out.println("测试状态B");
    }
}
