package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 */
class ActiveObjectProxy implements ActiveObject {
    private final SchedulerThread scheduleThread;
    private final Servant servant;

    public ActiveObjectProxy(SchedulerThread scheduleThread, Servant servant) {
        this.scheduleThread = scheduleThread;
        this.servant = servant;
    }

    @Override
    public Result makeString(int count, char fillChar) {
        FutureResult futureResult = new FutureResult();
        scheduleThread.invoke(new MakeStringRequest(servant, futureResult, count, fillChar));
        return futureResult;
    }

    @Override
    public void displayString(String text) {
        scheduleThread.invoke(new DisplayStringRequest(servant, text));
    }
}
