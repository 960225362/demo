package com.example.demo.huyue.design.iterator;

/**
 * @author huyue01@sinovatech.com 2019/12/7 12:10
 */
public class Client {
    public static void main(String[] args) {
        ConcreteAscAggregate concreteAscAggregate = new ConcreteAscAggregate();
        concreteAscAggregate.add("战三");
        concreteAscAggregate.add("李四");
        concreteAscAggregate.add("王五");
        concreteAscAggregate.add("飞流");
        concreteAscAggregate.add("阿西吧");

        MyIterator myIterator = new ConcreteMyIterator(concreteAscAggregate);
//        while (myIterator.isDone()){
//            System.out.println("=======>"+myIterator.currentItem()+"已经到达战场");
//            myIterator.next();
//        }

        concreteAscAggregate.remove("李四");
        concreteAscAggregate.remove("飞流");

        while (myIterator.isDone()){
            System.out.println("=======>"+myIterator.currentItem()+"已经远离战场");
            myIterator.next();
        }


    }
}
