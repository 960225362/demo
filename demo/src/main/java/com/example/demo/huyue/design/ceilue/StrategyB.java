package com.example.demo.huyue.design.ceilue;

/**
 * @author huyue01@sinovatech.com 2019/10/2 15:32
 */
public class StrategyB implements Strategy {
    @Override
    public void doStrategy(String str) {
        System.out.println("StrategyB======="+str);
    }
}
