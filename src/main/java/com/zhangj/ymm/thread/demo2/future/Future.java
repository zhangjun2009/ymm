package com.zhangj.ymm.thread.demo2.future;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public interface Future<T> {
    T get() throws InterruptedException;
}
