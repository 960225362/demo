package com.example.demo.huyue.design.jaindangongchan;

/**
 * @author huyue01@sinovatech.com 2019/5/4 21:48
 */
public class Client {
    public static void main(String[] args) {
        //生产技术产品
//        ProductFactory.getProduct(ProductEnum.TECHNOLOGY).product();
//        //生产硬件产品
//        ProductFactory.getProduct(ProductEnum.HARDWARE).product();

        //生产技术产品
        new TechProductFactory().getProduct().product();
        //生产硬件产品
        new HardProductFactory().getProduct().product();

    }
}
