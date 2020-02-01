package com.example.demo.huyue.design.adpter;

/**
 * @author huyue01@sinovatech.com 2019/11/23 11:50
 */
public class AdaterCompany implements Company {
    private NotCompany notCompany;

    public AdaterCompany(NotCompany notCompany) {
        this.notCompany = notCompany;
    }

    public AdaterCompany() {
    }

    @Override
    public void show() {
        notCompany.show();
    }
}
