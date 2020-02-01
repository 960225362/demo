package com.example.demo.huyue.design.zhizelian;

/**
 * @author huyue01@sinovatech.com 2019/12/20 20:14
 */
public class SecondManager extends Manager {
    public SecondManager(String name) {
        super(name);
    }

    @Override
    void handler(Integer integer) {
        if (2==integer){
            System.out.println("我是二把手只处理integer=2的事情");
        }else {
            if (null!=superManager){
                superManager.handler(integer);
            }
        }

    }
}
