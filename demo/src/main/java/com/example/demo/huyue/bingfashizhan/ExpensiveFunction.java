package com.example.demo.huyue.bingfashizhan;

import java.math.BigInteger;

/**
 * @author huyue01@sinovatech.com 2019/5/3 14:11
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
