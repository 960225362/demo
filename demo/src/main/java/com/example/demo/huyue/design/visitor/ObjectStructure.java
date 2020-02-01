package com.example.demo.huyue.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyue01@sinovatech.com 2020/1/1 12:45
 */
public class ObjectStructure {
    private List<Element> elementList = new ArrayList<>();

    public  void  add(Element element){
        elementList.add(element);
    }

    public void remove(Element element){
        elementList.remove(element);
    }

    public void accept(Visitor visitor){
        elementList.forEach(e->e.accept(visitor));
    }
}
