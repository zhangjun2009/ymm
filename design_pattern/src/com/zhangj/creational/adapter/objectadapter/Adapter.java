package com.zhangj.creational.adapter.objectadapter;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
