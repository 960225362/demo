package com.example.demo.huyue.dubbo.rpc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huyue01@sinovatech.com 2020/1/5 13:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {
   @Autowired
   private Hello hello;

    @Test
    public void say() {

//        ProxyFactory factory = new ProxyFactory(Hello.class);
//        Hello hello1 = factory.getProxyObject();
//        hello1.say();
        hello.say();
    }
}
