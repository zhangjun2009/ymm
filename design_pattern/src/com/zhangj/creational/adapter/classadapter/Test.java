package com.zhangj.creational.adapter.classadapter;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Test {
    public static void main(String[] args) {
        Target adapter = new Adapter();
        adapter.request();
    }
}
