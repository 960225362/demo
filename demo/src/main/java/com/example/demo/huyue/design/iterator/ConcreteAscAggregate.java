package com.example.demo.huyue.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyue01@sinovatech.com 2019/12/7 12:04
 */
public class ConcreteAscAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();

    @Override
    public MyIterator createMyIterator() {
        return new ConcreteMyIterator(this);
    }

    @Override
    public int count(){
        return items.size();
    }

    @Override
    public void add(Object object){
        items.add(object);
    }


    @Override
    public void remove(Object object){
       items.remove(object);
    }

    @Override
    public Object get(int index){
        return items.get(index);
    }
}
