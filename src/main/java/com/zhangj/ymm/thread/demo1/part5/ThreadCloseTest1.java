package com.zhangj.ymm.thread.demo1.part5;

/**
 * @author zhangj
 * @date 2019/3/12
 * 通过标志位关闭线程
 */
public class ThreadCloseTest1 {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(5_000);
        worker.shutDown();
    }

    public static class Worker extends Thread {
        private boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                System.out.println("working......");
            }
        }

        public void shutDown() {
            this.flag = false;
        }
    }
}
