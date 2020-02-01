package com.example.demo.huyue.design.iterator;

/**
 * @author huyue01@sinovatech.com 2019/12/7 11:42
 */
public interface MyIterator {
    Object first();
    Object next();
    boolean isDone();
    Object currentItem();
}
