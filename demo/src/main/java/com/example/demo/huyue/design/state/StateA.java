package com.example.demo.huyue.design.state;

/**
 * @author huyue01@sinovatech.com 2019/11/10 12:21
 */
public class StateA implements State {
    @Override
    public void handle(Context context) {
        context.setState(new StateB());
        System.out.println("测试状态A");
    }
}
