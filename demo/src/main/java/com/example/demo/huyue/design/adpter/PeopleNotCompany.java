package com.example.demo.huyue.design.adpter;

/**
 * @author huyue01@sinovatech.com 2019/11/23 11:53
 */
public class PeopleNotCompany implements NotCompany {
    @Override
    public void show() {
        System.out.println("我不是这个公司的员工");
    }
}
