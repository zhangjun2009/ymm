package com.zhangj.ymm.thread.juc.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/22
 */
public class ExecutorsExample1 {
    public static void main(String[] args) throws InterruptedException {
        useCacheThreadPool();
    }

    private static void useCacheThreadPool() throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        System.out.println(executorService.getActiveCount());
        executorService.execute(() -> System.out.println("============"));
        System.out.println(executorService.getActiveCount());
        IntStream.range(1, 100).boxed().forEach(i -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "[" + i + "]");
            });
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println(executorService.getActiveCount());
    }
}
