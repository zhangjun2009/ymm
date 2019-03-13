package com.zhangj.ymm.thread.demo1.part6;

/**
 * @author zhangj
 * @date 2019/3/13
 * 死锁样列
 */
public class DeadLock {
    private final Object LOCK = new Object();
    private OtherService otherService;

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    public void m1() {
        synchronized (LOCK) {
            System.out.println("m1===============================");
            otherService.s1();
        }
    }

    public void m2() {
        synchronized (LOCK) {
            System.out.println("m2===============================");
        }
    }
}
