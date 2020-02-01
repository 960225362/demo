package com.example.demo.huyue.design.visitor;

/**
 * @author huyue01@sinovatech.com 2020/1/1 12:27
 */
public interface Element {
    void accept(Visitor visitor);
}
