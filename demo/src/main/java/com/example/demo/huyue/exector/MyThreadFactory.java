package com.example.demo.huyue.exector;

/**
 * @author huyue01@sinovatech.com 2019/5/4 14:28
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
