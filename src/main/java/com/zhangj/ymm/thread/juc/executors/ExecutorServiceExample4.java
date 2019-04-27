package com.zhangj.ymm.thread.juc.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangj
 * @date 2019/4/27
 */
public class ExecutorServiceExample4 {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        executorService.getQueue().add(() -> System.out.println("xxxxx"));
    }
}
