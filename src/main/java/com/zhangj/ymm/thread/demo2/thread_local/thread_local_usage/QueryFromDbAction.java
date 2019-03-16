package com.zhangj.ymm.thread.demo2.thread_local.thread_local_usage;

/**
 * @author zhangj
 * @date 2019/3/16
 * 模拟从DB获取到name
 */
public class QueryFromDbAction {

    public void execute() {
        try {
            Thread.sleep(1000L);
            String name = "zhangj" + Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
