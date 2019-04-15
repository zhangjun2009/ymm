package com.zhangj.ymm.thread.juc.utils.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/13
 */
public class SemaphoreExample4 {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(5);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    semaphore.drainPermits();
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("t1 exception" + e.getMessage());
                } finally {
                    semaphore.release(5);
                }
            }
        };
        t1.start();
        TimeUnit.MILLISECONDS.sleep(50);
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    System.out.println("t2 exception" + e.getMessage());
                } finally {
                    semaphore.release();
                }
            }
        };
        t2.start();
    }
}
