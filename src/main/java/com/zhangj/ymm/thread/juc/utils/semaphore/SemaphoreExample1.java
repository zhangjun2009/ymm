package com.zhangj.ymm.thread.juc.utils.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/13
 */
public class SemaphoreExample1 {
    public static void main(String[] args) {
        final SemaphoreLock lock = new SemaphoreLock();
        IntStream.rangeClosed(1, 2).forEach(i -> {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running.");
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " get the lock.");
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unLock();
                    }
                    System.out.println(Thread.currentThread().getName() + " release the lock.");
                }
            }.start();
        });
    }

    static class SemaphoreLock {
        private final Semaphore semaphore = new Semaphore(1);

        public void lock() throws InterruptedException {
            semaphore.acquire();
        }

        public void unLock() {
            semaphore.release();
        }
    }
}
