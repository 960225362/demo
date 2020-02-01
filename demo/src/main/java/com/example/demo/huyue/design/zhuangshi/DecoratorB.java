package com.example.demo.huyue.design.zhuangshi;

/**
 * @author huyue01@sinovatech.com 2019/10/3 17:30
 */
    public class DecoratorB extends Decorator {
        @Override
        public void Operation() {
            super.Operation();
            say();
        }

        private void say(){
            System.out.println("DecoratorB 独有的方法");
        }
    }
