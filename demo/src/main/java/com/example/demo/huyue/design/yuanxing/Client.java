package com.example.demo.huyue.design.yuanxing;

/**
 * @author huyue01@sinovatech.com 2019/10/6 14:28
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a = new Resume("韩信");
        a.setAge("男","12");
        a.setWorkExperience("1988-2009","阿拉巴巴");

        Resume b = (Resume) a.clone();
        b.setWorkExperience("1999-8009","京东商城");

        Resume c = (Resume) a.clone();
        c.setWorkExperience("1945-9099","五把统称");

        a.display();
        b.display();
        c.display();
    }
}
