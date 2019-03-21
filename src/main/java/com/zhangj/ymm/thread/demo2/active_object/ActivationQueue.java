package com.zhangj.ymm.thread.demo2.active_object;

import java.util.LinkedList;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public class ActivationQueue {
    private final static int MAX_METHOD_REQUEST_SIZE = 100;
    private final LinkedList<MethodRequest> methodQueue;

    public ActivationQueue() {
        methodQueue = new LinkedList<>();
    }

    public synchronized void put(MethodRequest request) {
        while (methodQueue.size() >= MAX_METHOD_REQUEST_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.methodQueue.addLast(request);
        this.notifyAll();
    }

    public synchronized MethodRequest take() {
        while (methodQueue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MethodRequest request = methodQueue.removeFirst();
        this.notifyAll();
        return request;
    }
}
