package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public final class ActiveObjectFactory {
    public ActiveObjectFactory() {
    }

    public static ActiveObject createActiveObject() {
        Servant servant = new Servant();
        ActivationQueue activationQueue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(activationQueue);
        ActiveObjectProxy activeObjectProxy = new ActiveObjectProxy(schedulerThread, servant);
        schedulerThread.start();
        return activeObjectProxy;
    }
}
