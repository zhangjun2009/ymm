package com.zhangj.ymm.thread.demo3;

/**
 * @author zhangj
 * @date 2019/3/27
 */
public class ThreadContextClassLoader {
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
