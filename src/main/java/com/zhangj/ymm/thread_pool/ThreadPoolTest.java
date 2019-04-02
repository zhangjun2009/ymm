package com.zhangj.ymm.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/1
 */
public class ThreadPoolTest {
    private final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(1, 2,
            1, TimeUnit.HOURS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            THREAD_POOL.submit(() -> {
                try {
                    test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void test() throws InterruptedException {
        System.out.println("线程名称：" + Thread.currentThread().getName() + " start");
        Thread.sleep(5000);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " end");
    }
}
