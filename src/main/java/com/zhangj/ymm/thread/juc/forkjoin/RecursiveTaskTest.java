package com.zhangj.ymm.thread.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/20
 */
public class RecursiveTaskTest {
    private final static int MAX_THRESHOLD = 3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> task = forkJoinPool.submit(new CalculateRecursiveTask(1, 1000000000));
        System.out.println(task.get());
    }

    private static class CalculateRecursiveTask extends RecursiveTask<Integer> {
        private final int start;
        private final int end;

        private CalculateRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= MAX_THRESHOLD) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                int middle = (start + end) / 2;
                CalculateRecursiveTask leftTask = new CalculateRecursiveTask(start, middle);
                CalculateRecursiveTask rightTask = new CalculateRecursiveTask(middle + 1, end);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join() + rightTask.join();
            }
        }
    }
}
