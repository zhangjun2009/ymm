package com.zhangj.ymm.thread.juc.executors;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/27
 */
public class ExecutorServiceExample3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //test();
        //testAllowCoreThreadTimeOut();
        //testRemove();
        //testPrestartCoreThreads();
        //testThreadPoolAdvice();
        //testInvokeAny();
        //testInvokeAnyTimeOut();
        //testInvokeAll();
        //testSubmit();
        testGetQueue();
    }

    private static void testGetQueue() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.getQueue().add(() -> System.out.println(111));
    }

    private static void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> submit = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Object NUll = submit.get();
        System.out.println("R:" + NUll);
    }

    private static void testInvokeAll() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Callable<Integer>> collect = IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + " :" + i);
            return i;
        }).collect(Collectors.toList());
        List<Future<Integer>> futures = executorService.invokeAll(collect);
        futures.stream().map(ExecutorServiceExample3::apply).forEach(System.out::println);
        System.out.println("======================");
    }

    private static void testInvokeAny() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Callable<Integer>> collect = IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + " :" + i);
            return i;
        }).collect(Collectors.toList());
        Integer integer = executorService.invokeAny(collect);
        System.out.println("return the value " + integer);
        System.out.println("======================");
    }

    private static void testInvokeAnyTimeOut() throws InterruptedException, TimeoutException, ExecutionException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Callable<Integer>> collect = IntStream.range(0, 5).boxed().map(i -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + " :" + i);
            return i;
        }).collect(Collectors.toList());
        Integer integer = executorService.invokeAny(collect, 1, TimeUnit.SECONDS);
        System.out.println("return the value " + integer);
        System.out.println("======================");
    }

    private static void testThreadPoolAdvice() {
        ThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.AbortPolicy()
        );
        threadPoolExecutor.execute(new MyRunnable(1) {
            @Override
            public void run() {
                System.out.println("==================");
            }
        });
    }

    private static Integer apply(Future<Integer> f) {
        try {
            return f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private abstract static class MyRunnable implements Runnable {
        private final int no;

        protected MyRunnable(int no) {
            this.no = no;
        }

        public int getData() {
            return this.no;
        }

    }

    private static class MyThreadPoolExecutor extends ThreadPoolExecutor {

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            System.out.println("init the " + ((MyRunnable) r).getData());
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            if (null == t) {
                System.out.println("successful " + ((MyRunnable) r).getData());
            } else {
                t.printStackTrace();
            }
        }
    }

    private static void testPrestartCoreThreads() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        System.out.println(executorService.getActiveCount());
        executorService.prestartCoreThread();
        System.out.println(executorService.getActiveCount());
        executorService.prestartCoreThread();
        System.out.println(executorService.getActiveCount());
        executorService.prestartCoreThread();
        System.out.println(executorService.getActiveCount());
    }

    private static void testRemove() throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        IntStream.range(0, 2).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " working......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        TimeUnit.SECONDS.sleep(1);
        Runnable runnable = () -> {
            System.out.println("i will never be executed!");
        };
        executorService.execute(runnable);
        TimeUnit.SECONDS.sleep(1);
        executorService.remove(runnable);
    }

    private static void testAllowCoreThreadTimeOut() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executorService.setKeepAliveTime(3, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);
        IntStream.range(0, 5).boxed().forEach(i -> executorService.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " begin,");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }

    private static void test() throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        System.out.println(executorService.getActiveCount());
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.MILLISECONDS.sleep(20);
        System.out.println(executorService.getActiveCount());
    }
}
