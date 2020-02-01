package com.example.demo.huyue.design.iterator;

/**
 * @author huyue01@sinovatech.com 2019/12/7 11:59
 */
public interface Aggregate {
    MyIterator createMyIterator();
    int count();
    void add(Object object);
    void remove(Object object);
    Object get(int index);
}
