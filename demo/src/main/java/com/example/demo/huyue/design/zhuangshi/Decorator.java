package com.example.demo.huyue.design.zhuangshi;

/**
 * @author huyue01@sinovatech.com 2019/10/3 17:23
 */
public abstract class Decorator implements Component {
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    public void Operation(){
        if (component!=null){
            component.Operation();
        }
    }
}
