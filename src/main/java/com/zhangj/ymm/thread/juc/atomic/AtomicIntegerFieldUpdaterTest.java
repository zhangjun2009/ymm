package com.zhangj.ymm.thread.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author zhangj
 * @date 2019/4/2
 */
public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        TestMe testMe = new TestMe();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        int v = updater.getAndIncrement(testMe);
                        System.out.println(Thread.currentThread().getName() + "=>" + v);
                    }
                }
            }.start();
        }
    }

    static class TestMe {
        volatile int i;
    }
}
