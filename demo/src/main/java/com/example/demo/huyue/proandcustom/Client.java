package com.example.demo.huyue.proandcustom;

/**
 * @author huyue01@sinovatech.com 2019/2/14 11:25
 */
public class Client {
    public static void main(String[] args) {
        WareHouse house = new WareHouse(30);
       new Produce(60,house).start();
       new Produce(20,house).start();
       new Produce(60,house).start();
       new Consume(10,house).start();
       new Consume(20,house).start();
       new Consume(30,house).start();
       new Consume(40,house).start();
       new Consume(90,house).start();

    }
}
