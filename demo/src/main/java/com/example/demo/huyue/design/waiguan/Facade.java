package com.example.demo.huyue.design.waiguan;

/**
 * @author huyue01@sinovatech.com 2019/10/7 12:38
 */
public class Facade {
    private SuSystemOne suSystemOne;
    private SuSystemTwo suSystemTwo;
    private SuSystemThree suSystemThree;

    public Facade() {
        this.suSystemOne = new SuSystemOne();
        this.suSystemTwo = new SuSystemTwo();
        this.suSystemThree = new SuSystemThree();
    }

    public void methodA(){
        suSystemOne.methodOne();
        suSystemTwo.methodTwo();
        suSystemThree.methodThree();
        System.out.println("--------end-------");

    }
}
