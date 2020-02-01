package com.example.demo.huyue.design.guanchazhe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyue01@sinovatech.com 2019/11/3 12:02
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void Attach(Observer observer){
        observers.add(observer);
    }

    public void Detach(Observer observer){
        observers.remove(observer);
    }

    public void  notifyObserver(){
        observers.forEach(Observer::update);
    }
}
