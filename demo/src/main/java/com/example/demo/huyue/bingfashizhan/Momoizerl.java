package com.example.demo.huyue.bingfashizhan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huyue01@sinovatech.com 2019/5/3 14:12
 */
public class Momoizerl<A,V> implements Computable<A,V> {
    private final Map<A,V> cache=new HashMap<A,V>();
    private final Computable<A,V> c;

    public Momoizerl(Computable<A, V> c) {
        this.c = c;
    }


    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (null==result){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
