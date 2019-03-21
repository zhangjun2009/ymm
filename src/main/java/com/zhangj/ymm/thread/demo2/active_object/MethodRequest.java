package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 * 对应ActiveObject的每个方法
 */
public abstract class MethodRequest {
    public final Servant servant;
    public final FutureResult futureResult;

    protected MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
