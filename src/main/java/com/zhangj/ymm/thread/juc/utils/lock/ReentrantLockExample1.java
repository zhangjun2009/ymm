package com.zhangj.ymm.thread.juc.utils.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangj
 * @date 2019/4/13
 */
public class ReentrantLockExample1 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
//        IntStream.rangeClosed(0, 2).forEach(i -> new Thread() {
//            @Override
//            public void run() {
//                needLock();
//            }
//        }.start());
        Thread t1 = new Thread() {
            @Override
            public void run() {
                testLockInterruptibly();
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread() {
            @Override
            public void run() {
                testLockInterruptibly();
            }
        };
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(lock.getQueueLength());
        System.out.println(lock.hasQueuedThreads());
        System.out.println(lock.hasQueuedThread(t1));
        System.out.println(lock.hasQueuedThread(t2 ));
    }

    public static void testTryLock() {
        if (lock.tryLock()) {
            try {
                System.out.println("The thread " + Thread.currentThread().getName() + " get the lock.");
                while (true) {

                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("The thread " + Thread.currentThread().getName() + " not get the lock.");
        }
    }

    public static void testLockInterruptibly() {
        try {
            lock.lock();
            System.out.println("The thread " + Thread.currentThread().getName() + " get the lock.");
            System.out.println(Thread.currentThread().getName() + ":" + lock.getHoldCount());
            while (true) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void needLock() {
        try {
            lock.lock();
            System.out.println("The thread " + Thread.currentThread().getName() + " get the lock.");
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
