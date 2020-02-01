package com.example.demo.huyue.design.ceilue;

/**
 * @author huyue01@sinovatech.com 2019/10/2 15:31
 */
public class StrategyA implements Strategy {
    @Override
    public void doStrategy(String str) {
        System.out.println("StrategyA======="+str);
    }
}
