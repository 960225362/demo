package com.example.demo.huyue.dubbo.rpc;

import org.springframework.stereotype.Service;

/**
 * @author huyue01@sinovatech.com 2020/1/5 12:55
 */
@Service
public class HelloImpl implements Hello {
    @Override
    public void say() {
        System.out.println("hello world 2020");
    }
}
