package com.example.demo.huyue.locktest;

/**
 * @author huyue01@sinovatech.com 2019/2/14 9:14
 */
public class Client {
    public static void main(String[] args) {
//        ReentrantLockThread thread  = new ReentrantLockThread();
//        new Thread(thread).start();
//        new Thread(thread).start();
//        new Thread(thread).start();
//        new Thread(thread).start();
//        new Thread(thread).start();
//        new Thread(thread).start();

        /*
        * a线程执行后发现lock没有被占用，所以占用lock，获得c1锁，输出一句话，然后执行c2.signal，因为现在
        * c2锁未被占用，所以这一句没有发生效应，接着执行c1.await，导致当前线程停止并解除占用lock，此时的线程
        * 就在c1上等待。与此同时线程b也在执行，当他发现lock没有被占用就会将其占用，输出一句话，然后执行c1.signal
        * 这个时候c1上的线程就会别唤醒，争抢lock，但是此时的lock是被线程被占用的，等到执行c2.await,导致当先线程b、
        * 停止，并释放lock，b线程在c2上面等待，此时线程a就可以占用lock继续执行，如此循环往复
        * */
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        new Thread(a).start();
        new Thread(b).start();
    }
}
