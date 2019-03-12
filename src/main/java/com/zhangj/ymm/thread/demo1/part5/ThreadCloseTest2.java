package com.zhangj.ymm.thread.demo1.part5;

/**
 * @author zhangj
 * @date 2019/3/12
 * 通过interrupt中断线程
 */
public class ThreadCloseTest2 {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(5_000);
        worker.interrupt();
        System.out.println("worker is closed.");
    }


    public static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                if (interrupted()) {
                    break;
                }
                System.out.println("working......");
            }
        }
    }
}
