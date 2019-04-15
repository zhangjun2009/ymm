package com.zhangj.ymm.thread.juc.utils.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangj
 * @date 2019/4/15
 */
public class ConditionExample3 {
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();
    private static int data = 0;
    private static volatile boolean noUse = true;

    public static void main(String[] args) {
        new Thread(() -> {
            for (; ; ) {
                buildData();
            }
        }).start();
        new Thread(() -> {
            for (; ; ) {
                useData();
            }
        }).start();
    }

    private static void buildData() {
        try {
            //lock.lock();//synchronrzed
            while (noUse) {
                condition.await();//monitor.wait()
            }
            data++;
            System.out.println("P=>" + data);
            TimeUnit.SECONDS.sleep(1);
            noUse = true;
            condition.signal();//monitor.notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //lock.unlock();
        }
    }

    private static void useData() {
        try {
            //lock.lock();
            while (!noUse) {
                condition.await();
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println("c=>" + data);
            noUse = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //lock.unlock();
        }
    }
}
