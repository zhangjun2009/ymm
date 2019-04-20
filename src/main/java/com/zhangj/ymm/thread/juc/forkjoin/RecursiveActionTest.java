package com.zhangj.ymm.thread.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/4/20
 */
public class RecursiveActionTest {
    private final static int MAX_THRSHOLD = 3;
    private final static AtomicInteger SUM = new AtomicInteger(0);

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> System.out.println(SUM.get()), new CalculateRecursiveAction(0, 10));
    }

    private static class CalculateRecursiveAction extends RecursiveAction {
        private final int start;
        private final int end;

        private CalculateRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_THRSHOLD) {
                SUM.addAndGet(IntStream.rangeClosed(start, end).sum());
            } else {
                int middle = (start + end) / 2;
                CalculateRecursiveAction leftAction = new CalculateRecursiveAction(start, middle);
                CalculateRecursiveAction rightAction = new CalculateRecursiveAction(middle + 1, end);
                leftAction.fork();
                rightAction.fork();
            }
        }
    }
}
