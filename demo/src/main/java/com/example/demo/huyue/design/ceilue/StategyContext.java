package com.example.demo.huyue.design.ceilue;

/**
 * @author huyue01@sinovatech.com 2019/10/2 15:34
 */
public class StategyContext {
    private Strategy strategy;
    private  String str;

    public StategyContext(Integer type,String str) {
        switch (type){
            case 1:
                this.strategy = new StrategyA();
                break;
            case 2:
                this.strategy = new StrategyB();
                break;
                default:
                    break;
        }
        this.str = str;
    }

    public void  getResult(){
        strategy.doStrategy(str);
    }
}
