package com.zhangj.ymm.thread.juc.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangj
 * @date 2019/5/1
 */
public class FutureExample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //testGet();
        //testGetTimeOut();
        testIsDone();
    }

    private static void testCancel() {

    }

    private static void testIsDone() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> {
            throw new RuntimeException();
        });
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(result);
            System.out.println(future.isDone());
        }

    }

    private static void testGet() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        Thread mainThread = Thread.currentThread();
        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        }.start();
        Integer result = future.get();
        System.out.println("=================" + result);
    }

    private static void testGetTimeOut() throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("i am waiting 10 sec.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        future.get(8, TimeUnit.SECONDS);
    }
}
