package com.example.demo.huyue.design.singleton;

import com.example.demo.huyue.singleton.SingleTon;

/**
 * 双检锁/双重校验锁（线程安全）
 */
public class SingleTonForDCL {
    //定义成static保证内存中只存在一份，使用volatile保证instance值改变之后立即刷新可见
    private volatile static SingleTonForDCL instance = null;

    //定义成私有的，防止外部类初始化
    private SingleTonForDCL() {
    }

    public static SingleTonForDCL getInstance() {
        //如果已经实例化直接返回
        if (null == instance) {
            //多线程模式下保证只有一个线程进来
            synchronized (SingleTon.class) {
                //再次判断是否已经实例化，防止重复实例化
                if (null == instance) {
                    instance = new SingleTonForDCL();
                }
            }
        }
        return instance;
    }
}
