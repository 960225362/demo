package com.example.demo.huyue.design.xiangyuan;

/**
 * @author huyue01@sinovatech.com 2019/12/22 16:39
 */
public abstract class WebSite {
    protected String name;

    public WebSite(String name) {
        this.name = name;
    }

    public abstract void show(User user);
}
