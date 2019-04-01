package com.zhangj.ymm.thread.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangj
 * @date 2019/3/31
 */
public class CompareAndSetLock {
    private final AtomicInteger value = new AtomicInteger(0);
    private Thread lockedThread;

    public void tryLock() throws GetLockException {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new GetLockException("Get the lock failed.");
        } else {
            lockedThread = Thread.currentThread();
        }
    }

    public void unLock() {
        if (0 == value.get()) {
            return;
        }
        if (lockedThread == Thread.currentThread()) {
            value.compareAndSet(1, 0);
        }
    }
}
