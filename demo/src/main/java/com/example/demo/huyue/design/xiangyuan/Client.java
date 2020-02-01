package com.example.demo.huyue.design.xiangyuan;

/**
 * @author huyue01@sinovatech.com 2019/12/22 16:57
 */
public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite webSiteA = factory.getWebSite("A");
        WebSite webSiteB = factory.getWebSite("B");

        User userA = new User("范闲","123456");
        User userB = new User("王启年","654321");
        webSiteA.show(userA);
        webSiteB.show(userB);
        System.out.println(factory.getWebSiteCount());
    }
}
