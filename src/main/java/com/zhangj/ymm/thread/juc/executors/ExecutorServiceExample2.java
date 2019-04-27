package com.zhangj.ymm.thread.juc.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/27
 */
public class ExecutorServiceExample2 {
    public static void main(String[] args) throws InterruptedException {
        //testAbortPolicy();
        //testDiscardPolicy();
        //testCallerRunsPolicy();
        testDiscardOldestPolicy();
    }

    private static void testDiscardOldestPolicy() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " working......");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.SECONDS.sleep(1);
        threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println("=============================");
    }

    private static void testCallerRunsPolicy() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " working......");
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.SECONDS.sleep(1);
        threadPoolExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("=============================");
    }

    private static void testAbortPolicy() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 4; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " working......");
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.SECONDS.sleep(1);
    }

    private static void testDiscardPolicy() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.DiscardPolicy()
        );
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " working......");
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.SECONDS.sleep(1);
        threadPoolExecutor.execute(() -> System.out.println("x"));
    }
}
