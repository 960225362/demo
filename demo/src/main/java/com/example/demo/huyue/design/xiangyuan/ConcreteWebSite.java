package com.example.demo.huyue.design.xiangyuan;

/**
 * @author huyue01@sinovatech.com 2019/12/22 16:45
 */
public class ConcreteWebSite extends WebSite {
    public ConcreteWebSite(String name) {
        super(name);
    }

    @Override
    public void show(User user) {
        System.out.println("网站名称："+name+"|网站账号："+user.getAccount()+"|网站密码："+user.getPassword());
    }
}
