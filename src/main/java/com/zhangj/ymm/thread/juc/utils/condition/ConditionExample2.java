package com.zhangj.ymm.thread.juc.utils.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangj
 * @date 2019/4/15
 */
public class ConditionExample2 {
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();
    private static int data = 0;
    private static volatile boolean noUse = true;

    public static void main(String[] args) {
        new Thread(() -> {
            for (; ; ) {
                buildData();
            }
        }, "P1").start();
        new Thread(() -> {
            for (; ; ) {
                useData();
            }
        }, "C1").start();
        new Thread(() -> {
            for (; ; ) {
                useData();
            }
        }, "C2").start();
    }

    private static void buildData() {
        try {
            lock.lock();//synchronrzed
            while (noUse) {
                condition.await();//monitor.wait()
            }
            data++;
            System.out.println(Thread.currentThread().getName() + " P=>" + data);
            noUse = true;
            condition.signalAll();//monitor.notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void useData() {
        try {
            lock.lock();
            while (!noUse) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " C=>" + data);
            noUse = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
