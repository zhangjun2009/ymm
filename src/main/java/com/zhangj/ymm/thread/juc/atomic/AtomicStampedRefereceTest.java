package com.zhangj.ymm.thread.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zhangj
 * @date 2019/3/31
 */
public class AtomicStampedRefereceTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference<Integer> atomicRef = new AtomicStampedReference<>(100, 0);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    boolean success1 = atomicRef.compareAndSet(100, 101, atomicRef.getStamp(), atomicRef.getStamp() + 1);
                    System.out.println("success1:" + success1);
                    boolean success2 = atomicRef.compareAndSet(101, 100, atomicRef.getStamp(), atomicRef.getStamp() + 1);
                    System.out.println("success2:" + success2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    int stamp = atomicRef.getStamp();
                    System.out.println("Before sleep stamp=" + stamp);
                    TimeUnit.SECONDS.sleep(2);
                    boolean success3 = atomicRef.compareAndSet(100, 101, stamp, stamp + 1);
                    System.out.println("success3:" + success3);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
