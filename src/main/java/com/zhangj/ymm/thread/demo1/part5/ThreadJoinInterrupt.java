package com.zhangj.ymm.thread.demo1.part5;

/**
 * @author zhangj
 * @date 2019/3/12
 * join 中断
 */
public class ThreadJoinInterrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " working.......");
                }
            }
        };
        t1.start();

        Thread main = Thread.currentThread();

        Thread t2 = new Thread(() -> {
            main.interrupt();
        });
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish done.");
    }
}
