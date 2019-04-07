package com.example.demo.huyue.jdk;

import java.util.Collection;

/**
 * @author huyue01@sinovatech.com 2019/3/31 17:56
 */
public interface Myinterface {
    void rest();
    default String getString (){
        return null;
    };

    static String getString(String string){
        return null;
    }

}
