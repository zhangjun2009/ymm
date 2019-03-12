package com.zhangj.ymm.thread.demo2.future;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }
}
