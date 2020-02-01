package com.example.demo.huyue.design.jaindangongchan;

/**
 * @author huyue01@sinovatech.com 2019/5/4 21:38
 */
public enum ProductEnum {
    TECHNOLOGY(1,"技术"),
    HARDWARE(2,"硬件");


    private int code;
    private String name;

    ProductEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
