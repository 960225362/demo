package com.example.demo.huyue.design.jaindangongchan;

/**
 * @author huyue01@sinovatech.com 2019/5/4 21:33
 */
public class ProductFactory {
    private static Product product;

    public static Product getProduct(ProductEnum sign) {
        switch (sign) {
            case TECHNOLOGY:
                product = new TechProduct();
                break;
            case HARDWARE:
                product = new HardProduct();
                break;
            default:
                break;
        }
        return product;
    }
}
