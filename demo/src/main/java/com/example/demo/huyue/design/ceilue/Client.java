package com.example.demo.huyue.design.ceilue;

/**
 * @author huyue01@sinovatech.com 2019/10/2 15:33
 */
public class Client {
    public static void main(String[] args) {
        StategyContext contextA = new StategyContext(1,"策略A");
        StategyContext contextB = new StategyContext(2,"策略B");
        contextA.getResult();
        contextB.getResult();
    }
}
