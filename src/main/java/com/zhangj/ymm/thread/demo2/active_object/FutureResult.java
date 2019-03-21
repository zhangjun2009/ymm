package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public class FutureResult implements Result {
    private Result result;
    private volatile boolean ready = false;

    public synchronized void setResult(Result result) {
        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    @Override
    public synchronized Object getResultValue() {
        while (!ready) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.result.getResultValue();
    }
}
