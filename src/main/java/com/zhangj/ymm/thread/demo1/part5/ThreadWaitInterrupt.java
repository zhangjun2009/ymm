package com.zhangj.ymm.thread.demo1.part5;

/**
 * @author zhangj
 * @date 2019/3/12
 * 线程 wait 中断
 */
public class ThreadWaitInterrupt {
    private final static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread().getName() + " working......");
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
