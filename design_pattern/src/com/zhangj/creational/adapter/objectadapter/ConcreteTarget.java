package com.zhangj.creational.adapter.objectadapter;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("目标方法");
    }
}
