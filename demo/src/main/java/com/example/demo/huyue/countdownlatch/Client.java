package com.example.demo.huyue.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huyue01@sinovatech.com 2019/2/13 17:28
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        int countSize  = 5;
//        CountDownLatch count = new CountDownLatch(countSize);
//        for (int i = 0; i < countSize; i++) {
//            new CountDownTestThread(count).start();
//        }
//        count.await();
//        System.out.println("wail all finish");

        CyclicBarrier barrier = new CyclicBarrier(countSize);
        for (int i = 0; i < countSize; i++) {
            new CyclicBarrierTestThread(barrier).start();
        }
        System.out.println("wait all finish");
    }
}
