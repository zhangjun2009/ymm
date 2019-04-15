package com.zhangj.ymm.thread.juc.utils.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangj
 * @date 2019/4/13
 */
public class ReadWriteLockExample {
    private final static ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
    private final static Lock readLock = LOCK.readLock();
    private final static Lock writeLock = LOCK.writeLock();

    private final static List<Long> data = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> read());
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(() -> read());
        t2.start();
        TimeUnit.SECONDS.sleep(1);
    }

    public static void write() {
        try {
            writeLock.lock();
            data.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void read() {
        try {
            readLock.lock();
            data.forEach(System.out::println);
            System.out.println(Thread.currentThread().getName() + "=======================");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

}
