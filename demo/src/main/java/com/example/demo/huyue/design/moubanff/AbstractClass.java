package com.example.demo.huyue.design.moubanff;

/**
 * @author huyue01@sinovatech.com 2019/10/6 15:10
 */
public abstract class AbstractClass {
    public abstract void shuchuStart();
    public abstract void shuchuEnd();

    public void shuchu(){
        shuchuStart();
        shuchuEnd();
        System.out.println("-------end------");
    }
}
