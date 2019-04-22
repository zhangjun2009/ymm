package com.zhangj.ymm.thread.juc.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/22
 */
public class ThreadPoolExecutorLongTimeTask {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }, new ThreadPoolExecutor.AbortPolicy()
        );
        IntStream.range(0, 10).forEach(i -> threadPool.execute(() -> {
            while (true) {

            }
        }));
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("===============================");
    }
}
