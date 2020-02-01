package com.example.demo.huyue.bingfashizhan;

import com.sun.javaws.ui.LaunchErrorDialog;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author huyue01@sinovatech.com 2019/5/3 14:27
 */
public class Momoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Momoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> result = cache.get(arg);
            if (null == result) {
                Callable<V> callable = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> futureTask = new FutureTask<V>(callable);
                result = cache.putIfAbsent(arg, futureTask);
                if (null == result) {
                    result = futureTask;
                    futureTask.run();
                }
            }
            try {
                return result.get();
            } catch (CancellationException e) {
                cache.remove(arg, result);
            } catch (ExecutionException e) {
                throw new RuntimeException();
            }
        }
    }
}

