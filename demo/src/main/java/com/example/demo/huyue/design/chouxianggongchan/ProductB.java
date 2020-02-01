package com.example.demo.huyue.design.chouxianggongchan;

import org.springframework.stereotype.Component;

/**
 * @author huyue01@sinovatech.com 2019/11/9 14:24
 */
@Component
public class ProductB implements IProduct {
    @Override
    public void product() {
        System.out.println("开始生产B");
    }
}
