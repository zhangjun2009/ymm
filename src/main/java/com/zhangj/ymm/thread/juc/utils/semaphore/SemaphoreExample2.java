package com.zhangj.ymm.thread.juc.utils.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/13
 */
public class SemaphoreExample2 {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " in");
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " get the semaphore.");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println(Thread.currentThread().getName() + " out");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            }.start();
        }
        while (true) {
            System.out.println("AP->" + semaphore.availablePermits());
            System.out.println("QL->" + semaphore.getQueueLength());
            System.out.println("=====================================");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
