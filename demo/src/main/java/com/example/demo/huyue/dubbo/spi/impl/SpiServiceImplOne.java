package com.example.demo.huyue.dubbo.spi.impl;

import com.example.demo.huyue.dubbo.spi.SpiService;

/**
 * @author huyue01@sinovatech.com 2020/1/5 15:05
 */
public class SpiServiceImplOne implements SpiService {
    @Override
    public void test() {
        System.out.println("spi 测试一");
    }
}
