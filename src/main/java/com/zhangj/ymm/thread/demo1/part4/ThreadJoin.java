package com.zhangj.ymm.thread.demo1.part4;

/**
 * @author zhangj
 * @date 2019/3/12
 * 线程join
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " starting.");
                Thread.sleep(5_000);
                System.out.println(Thread.currentThread().getName() + " end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " starting.");
                Thread.sleep(4_000);
                System.out.println(Thread.currentThread().getName() + " end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("All tasks finish done.");
    }
}
