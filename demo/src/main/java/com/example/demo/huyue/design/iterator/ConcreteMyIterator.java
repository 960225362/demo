package com.example.demo.huyue.design.iterator;

/**
 * @author huyue01@sinovatech.com 2019/12/7 12:00
 */
public class ConcreteMyIterator implements MyIterator {
    private Aggregate aggregate;
    private static int current=0;

    public ConcreteMyIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.get(0);
    }

    @Override
    public Object next() {
        current++;
        return current<aggregate.count()?aggregate.get(current):null;
    }

    @Override
    public boolean isDone() {
        return current < aggregate.count();
    }

    @Override
    public Object currentItem() {
        return aggregate.get(current);
    }
}
