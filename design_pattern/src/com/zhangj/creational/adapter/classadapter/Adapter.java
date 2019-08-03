package com.zhangj.creational.adapter.classadapter;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
