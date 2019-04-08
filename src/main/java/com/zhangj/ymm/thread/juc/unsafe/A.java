package com.zhangj.ymm.thread.juc.unsafe;

/**
 * @author zhangj
 * @date 2019/4/6
 */
public class A {
    private int i = 0;

    public A() {
        this.i = 1;
    }

    public int get() {
        return i;
    }
}
