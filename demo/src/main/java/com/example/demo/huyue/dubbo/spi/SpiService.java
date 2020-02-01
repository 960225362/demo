package com.example.demo.huyue.dubbo.spi;

import com.example.demo.huyue.dubbo.spi.annotation.MySPI;

/**
 * @author huyue01@sinovatech.com 2020/1/5 15:04
 */
@MySPI("one")
public interface SpiService {
    void test();
}
