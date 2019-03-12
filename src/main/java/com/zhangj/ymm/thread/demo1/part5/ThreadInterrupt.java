package com.zhangj.ymm.thread.demo1.part5;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(isInterrupted() + ">>>>>>");
                }
            }
        };
        t.start();
        Thread.sleep(2_000);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
