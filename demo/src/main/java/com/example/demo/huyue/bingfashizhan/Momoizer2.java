package com.example.demo.huyue.bingfashizhan;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huyue01@sinovatech.com 2019/5/3 14:20
 */
public class Momoizer2<A, V> implements Computable<A, V> {
    private final ConcurrentHashMap<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Momoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (null == result) {
            result = compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
