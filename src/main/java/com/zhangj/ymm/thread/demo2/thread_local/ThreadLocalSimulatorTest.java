package com.zhangj.ymm.thread.demo2.thread_local;

import java.util.Random;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class ThreadLocalSimulatorTest {
    private static final ThreadLocalSimulator<String> threadLocal = new ThreadLocalSimulator<>();
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            threadLocal.set("Thread-T1");
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set("Thread-T2");
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("================================");
        System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
    }
}
