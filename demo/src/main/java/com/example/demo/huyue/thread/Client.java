package com.example.demo.huyue.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huyue01@sinovatech.com 2019/2/13 16:16
 */
@SuppressWarnings("unchecked")
public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadByCallableAndFuture future = new ThreadByCallableAndFuture();
        FutureTask task = new FutureTask(future);
        long startTime = System.currentTimeMillis();
        new Thread(task, "测试线程").start();
        long endTime = System.currentTimeMillis();
        System.out.println("返回的值为：" + task.get());
        System.out.println("运行的时间为：" + (endTime - startTime));
    }


}
