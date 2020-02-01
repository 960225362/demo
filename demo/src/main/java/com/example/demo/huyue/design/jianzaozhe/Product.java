package com.example.demo.huyue.design.jianzaozhe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyue01@sinovatech.com 2019/11/2 10:51
 */
public class Product {
    private List<String> parts = new ArrayList<>();

    public void addPart(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品创建-------");
        parts.forEach(p -> System.out.println("---------" + p));
    }
}
