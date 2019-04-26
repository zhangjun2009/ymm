package com.zhangj.ymm.work;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/3/15
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10, new MyThread());
        IntStream.range(0, 10).forEach(i -> executorService.execute(new MyTask(i) {
            @Override
            protected void doErrors(Exception e) {
                System.out.println(Thread.currentThread().getName() + " ,The no=" + i + " is error");
            }

            @Override
            protected void doExecute() {
                int temp = i / 0;
            }
        }));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("=========================");
    }

    private static class MyThread implements ThreadFactory {
        private final static AtomicInteger SEQ = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("MyThread-" + SEQ.getAndIncrement());
            thread.setUncaughtExceptionHandler((t, e) -> {
                System.out.println(t.getName() + " is error.");
                e.printStackTrace();
            });
            return thread;
        }
    }

    private static abstract class MyTask implements Runnable {
        private final int no;

        private MyTask(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            try {
                doExecute();
            } catch (Exception e) {
                doErrors(e);
            }
        }

        protected abstract void doErrors(Exception e);

        protected abstract void doExecute();
    }

    @Data
    @Accessors(fluent = true)
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class User {
        @JSONField(name = "s_id")
        private int sId;

        @JSONField(name = "user_name")
        private String userName;
    }

}
