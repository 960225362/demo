package com.example.demo.huyue.exector;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * @author huyue01@sinovatech.com 2019/5/4 14:21
 */
public class BoundedExcutor {
    private final Executor executor;
    private final Semaphore semaphore;

    public BoundedExcutor(Executor executor, Semaphore semaphore) {
        this.executor = executor;
        this.semaphore = semaphore;
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }

    }
}
