package com.example.demo.huyue.bingfashizhan;

/**
 * @author huyue01@sinovatech.com 2019/5/3 14:09
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
