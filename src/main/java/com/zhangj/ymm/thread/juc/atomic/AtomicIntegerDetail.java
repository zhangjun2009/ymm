package com.zhangj.ymm.thread.juc.atomic;

/**
 * @author zhangj
 * @date 2019/3/31
 */
public class AtomicIntegerDetail {
    private static final CompareAndSetLock LOCK = new CompareAndSetLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        doSomething2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (GetLockException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static void doSomething() throws InterruptedException {
        synchronized (AtomicIntegerDetail.class) {
            System.out.println(Thread.currentThread().getName() + "get the lock.");
            Thread.sleep(1000);
        }
    }

    public static void doSomething2() throws InterruptedException, GetLockException {
        try {
            LOCK.tryLock();
            System.out.println(Thread.currentThread().getName() + "get the lock.");
            Thread.sleep(2000);
        } finally {
            LOCK.unLock();
        }
    }
}
