package com.zhangj.ymm.thread.juc.executors;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/22
 */
public class ExecutorsExample1 {
    public static void main(String[] args) throws InterruptedException {
        //useCacheThreadPool();
        //useFixedSizePool();
        //useSinglePool();
        useWorkStealingPool();
    }

    private static void useWorkStealingPool() throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<String>> callableList = IntStream.range(0, 20).boxed().map(i -> (Callable<String>) () -> {
            //System.out.println("Thread" + Thread.currentThread().getName());
            sleepSecond(3);
            return "Task-" + i;
        }).collect(Collectors.toList());
        executorService.invokeAll(callableList).forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void sleepSecond(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void useSinglePool() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
    }

    private static void useFixedSizePool() throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
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
