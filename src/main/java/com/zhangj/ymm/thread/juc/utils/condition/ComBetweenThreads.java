package com.zhangj.ymm.thread.juc.utils.condition;

/**
 * @author zhangj
 * @date 2019/4/15
 */
public class ComBetweenThreads {
    private static int data = 0;
    private static boolean noUse = true;
    private final static Object MONITER = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            for (; ; ) {
                buildData();
            }
        }).start();
        new Thread(() -> {
            for (; ; ) {
                useData();
            }
        }).start();
    }

    private static void buildData() {
        synchronized (MONITER) {
            while (noUse) {
                try {
                    MONITER.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data++;
            System.out.println("P=>" + data);
            noUse = true;
            MONITER.notifyAll();
        }
    }

    private static void useData() {
        synchronized (MONITER) {
            while (!noUse) {
                try {
                    MONITER.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C=>" + data);
            noUse = false;
            MONITER.notifyAll();
        }
    }
}
