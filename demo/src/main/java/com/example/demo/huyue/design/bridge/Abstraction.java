package com.example.demo.huyue.design.bridge;

/**
 * @author huyue01@sinovatech.com 2019/12/14 16:22
 */
public abstract class Abstraction {
    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}
