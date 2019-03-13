package com.zhangj.ymm.thread.demo1.part6;

/**
 * @author zhangj
 * @date 2019/3/13
 */
public class DeadLockTest {
    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);
        new Thread(() -> {
            deadLock.m1();
        }).start();
        new Thread(() -> {
            otherService.s2();
        }).start();
    }
}
