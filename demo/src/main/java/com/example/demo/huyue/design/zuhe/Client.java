package com.example.demo.huyue.design.zuhe;

/**
 * @author huyue01@sinovatech.com 2019/11/30 11:22
 */
public class Client {
    public static void main(String[] args) {
        Compsite root = new Compsite("根");
        root.add(new Leaf("树叶A"));
        root.add(new Leaf("树叶B"));

        Compsite siteA = new Compsite("树干A");
        Compsite siteB = new Compsite("树干B");
        Compsite siteC = new Compsite("树干C");

        siteA.add(new Leaf("树叶C"));
        siteA.add(new Leaf("树叶D"));
        siteC.add(new Leaf("树叶E"));
        siteC.add(new Leaf("树叶F"));
        siteB.add(siteC);

        root.add(siteA);
        root.add(siteB);

        root.showContent();

        siteB.remove(siteC);

        System.out.println("---------------------分隔符--------------------");

        root.showContent();
    }
}
