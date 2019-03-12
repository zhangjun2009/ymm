package com.zhangj.ymm.thread.demo1.part5.closedforce;

/**
 * @author zhangj
 * @date 2019/3/12
 * 利用守护线程中断
 */
public class ThreadService {
    /**
     * 执行线程
     */
    private Thread executeThread;

    private boolean flag = false;

    public void execute(Runnable task) {
        executeThread = new Thread(() -> {
            Thread runnner = new Thread(task);
            runnner.setDaemon(true);
            runnner.start();
            try {
                runnner.join();
                flag = true;
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "closed.");
            }
        });
        executeThread.start();
    }

    public void shutDowm(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!flag) {
            if (System.currentTimeMillis() - currentTime >= mills) {
                System.out.println("任务超时,.结束他.");
                executeThread.interrupt();
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
    }
}
