package com.zhangj.creational.adapter;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Test {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter();
        adapter.outputDC5V();
    }
}
