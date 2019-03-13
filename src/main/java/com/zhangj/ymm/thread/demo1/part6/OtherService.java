package com.zhangj.ymm.thread.demo1.part6;

/**
 * @author zhangj
 * @date 2019/3/13
 */
public class OtherService {
    private final Object LOCK = new Object();
    private DeadLock deadLock;

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    public void s1() {
        synchronized (LOCK) {
            System.out.println("s1===============================");
        }
    }

    public void s2() {
        synchronized (LOCK) {
            System.out.println("s2===============================");
            deadLock.m2();
        }
    }
}
