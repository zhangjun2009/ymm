package com.zhangj.ymm.thread.demo2.thread_local.thread_local_context;

/**
 * @author zhangj
 * @date 2019/3/16
 * 模拟从DB获取到name
 */
public class QueryFromDbAction {

    public void execute(Context context) {
        try {
            Thread.sleep(1000L);
            String name = "zhangj" + Thread.currentThread().getName();
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
