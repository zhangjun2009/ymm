package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public class SchedulerThread extends Thread {
    private final ActivationQueue activationQueue;

    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }

    public void invoke(MethodRequest request) {
        activationQueue.put(request);
    }

    @Override
    public void run() {
        while (true) {
            activationQueue.take().execute();
        }
    }
}
