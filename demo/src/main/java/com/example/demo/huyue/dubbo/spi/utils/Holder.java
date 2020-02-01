package com.example.demo.huyue.dubbo.spi.utils;

/**
 * @author huyue01@sinovatech.com 2020/1/5 16:51
 */
public class Holder<T> {
    private volatile T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
