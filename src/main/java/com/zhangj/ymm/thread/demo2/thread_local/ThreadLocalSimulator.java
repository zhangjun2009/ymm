package com.zhangj.ymm.thread.demo2.thread_local;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class ThreadLocalSimulator<T> {
    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get() {
        synchronized (this) {
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if (null == value) {
                return initialValue();
            }
            return value;
        }
    }

    public T initialValue() {
        return null;
    }
}
