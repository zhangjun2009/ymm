package com.zhangj.ymm.thread.juc.unsafe;

/**
 * @author zhangj
 * @date 2019/4/3
 */
public class Hello {
    static {
        System.loadLibrary("hello");
    }

    private native void hi();

    public static void main(String[] args) {
        new Hello().hi();
    }
}
