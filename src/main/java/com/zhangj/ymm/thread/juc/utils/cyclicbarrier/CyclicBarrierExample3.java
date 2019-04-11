package com.zhangj.ymm.thread.juc.utils.cyclicbarrier;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangj
 * @date 2019/4/11
 */
public class CyclicBarrierExample3 {

    public static void main(String[] args) {
        MyCountDownLatch myCountDownLatch = new MyCountDownLatch(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all of worker finished.");
            }
        });

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myCountDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " finished work.");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myCountDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " finished work.");
            }
        }.start();
    }

    static class MyCountDownLatch extends CountDownLatch {
        private final Runnable runnable;

        public MyCountDownLatch(int count, Runnable runnable) {
            super(count);
            this.runnable = runnable;
        }

        @Override
        public void countDown() {
            super.countDown();
            if (super.getCount() == 0) {
                this.runnable.run();
            }
        }
    }
}
