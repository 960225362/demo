package com.example.demo.huyue.design.zuhe;

import com.example.demo.common.utils.SpringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyue01@sinovatech.com 2019/11/30 11:17
 */
public class Compsite extends Component {
    private List<Component> children = new ArrayList<>();

    public Compsite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void showContent() {
        System.out.println("树干节点："+name);
        children.forEach(Component::showContent);
    }
}
