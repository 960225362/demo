package com.example.demo.huyue.design.zuhe;

/**
 * @author huyue01@sinovatech.com 2019/11/30 11:14
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("叶子节点不能增加下级");

    }

    @Override
    public void remove(Component component) {
        System.out.println("叶子节点不能删除下级");
    }

    @Override
    public void showContent() {
        System.out.println("叶子节点："+name);
    }
}
