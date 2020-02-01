package com.example.demo.huyue.exector;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author huyue01@sinovatech.com 2019/5/4 14:29
 */
public class MyAppThread extends Thread {
    public final static String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static  final AtomicInteger created = new AtomicInteger();
    private static  final AtomicInteger alive = new AtomicInteger();
    private static  final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable target, String name) {
        super(target, name+"_"+created.incrementAndGet());
        setUncaughtExceptionHandler(
                (t, e) -> log.log(Level.SEVERE,"UNCAUGHT in thread"+t.getName(),e)
        );
    }

    @Override
    public void run() {
        boolean debug = debugLifecycle;
        if (debug)
            log.log(Level.FINE,"create "+getName());
        try {
            alive.incrementAndGet();
            super.run();
        }finally {
            alive.decrementAndGet();
            if (debug)
                log.log(Level.FINE,"exiting "+getName());
        }
    }

    public static boolean isDebugLifecycle() {
        return debugLifecycle;
    }

    public static void setDebugLifecycle(boolean debugLifecycle) {
        MyAppThread.debugLifecycle = debugLifecycle;
    }

    public static int getCreated() {
        return created.get();
    }

    public static int getAlive() {
        return alive.get();
    }
}
