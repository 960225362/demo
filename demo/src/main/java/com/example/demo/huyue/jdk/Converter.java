package com.example.demo.huyue.jdk;

/**
 * @author huyue01@sinovatech.com 2019/3/31 19:03
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F form);
}
