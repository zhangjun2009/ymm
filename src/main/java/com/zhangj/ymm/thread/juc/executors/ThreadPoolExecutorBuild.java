package com.zhangj.ymm.thread.juc.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/21
 */
public class ThreadPoolExecutorBuild {
    /**
     * <p>
     * 1:CoreSize=1,MaxSize=2,blockingQueue is empty ,what happen when submit 3 task?
     * 2:CoreSize=1,MaxSize=2,blockingQueue size =5 ,what happen when submit 7 task?
     * 3:CoreSize=1,MaxSize=2,blockingQueue size =5 ,what happen when submit 8 task?
     * <p/>
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = buildThreadPoolExecutor();
        int activeCount = -1;
        int queueSize = -1;
        while (true) {
            if (activeCount != poolExecutor.getActiveCount() || queueSize != poolExecutor.getQueue().size()) {
                System.out.println("ActiveCount=>" + poolExecutor.getActiveCount());
                System.out.println("PoolSize=>" + poolExecutor.getPoolSize());
                System.out.println("QueueSize=>" + poolExecutor.getQueue().size());
                System.out.println("MaximumPoolSize=>" + poolExecutor.getMaximumPoolSize());
                activeCount = poolExecutor.getActiveCount();
                queueSize = poolExecutor.getQueue().size();
                System.out.println("=====================================");
            }
        }
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    return t;
                }, new ThreadPoolExecutor.AbortPolicy()
        );
        threadPoolExecutor.execute(() -> sleepSecond(100));
        threadPoolExecutor.execute(() -> sleepSecond(10));
        threadPoolExecutor.execute(() -> sleepSecond(10));

        return threadPoolExecutor;
    }

    private static void sleepSecond(long seconds) {
        try {
            System.out.println("* " + Thread.currentThread().getName() + " *");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
