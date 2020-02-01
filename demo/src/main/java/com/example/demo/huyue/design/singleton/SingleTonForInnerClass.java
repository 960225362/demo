package com.example.demo.huyue.design.singleton;

/**
 * 登记式/静态内部类(线程安全)
 * 这种比饿汉式的那种在类加载的时候就初始化要好，
 * 不会浪费更多的资源
 */
public class SingleTonForInnerClass {
    private static class SingleTonHolder {
        private static SingleTonForInnerClass instance = new SingleTonForInnerClass();
    }

    public SingleTonForInnerClass getInstance() {
        return SingleTonHolder.instance;
    }
}

