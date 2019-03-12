package com.zhangj.ymm.thread.part1.part3;

/**
 * @author zhangj
 * @date 2019/3/12
 * 守护线程
 */
public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running");
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " done");

        });
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(5_000);
        System.out.println(Thread.currentThread().getName());
    }
}
