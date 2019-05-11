package com.zhangj.ymm.work;

import cn.hutool.core.util.HashUtil;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangj
 * @date 2019/3/15
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        System.out.println(HashUtil.bkdrHash("1222"));
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
