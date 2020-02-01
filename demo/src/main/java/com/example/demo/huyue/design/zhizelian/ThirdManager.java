package com.example.demo.huyue.design.zhizelian;

/**
 * @author huyue01@sinovatech.com 2019/12/20 20:17
 */
public class ThirdManager extends Manager {

    public ThirdManager(String name) {
        super(name);
    }

    @Override
    void handler(Integer integer) {
        if (3==integer){
            System.out.println("我是三把手只处理integer=3的事情");
        }else {
            if (null!=superManager){
                superManager.handler(integer);
            }
        }

    }
}
