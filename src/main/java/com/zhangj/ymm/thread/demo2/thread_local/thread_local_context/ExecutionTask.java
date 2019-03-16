package com.zhangj.ymm.thread.demo2.thread_local.thread_local_context;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class ExecutionTask implements Runnable {
    private QueryFromDbAction queryFromDbAction = new QueryFromDbAction();
    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        final Context context = new Context();
        queryFromDbAction.execute(context);
        queryFromHttpAction.execute(context);
        System.out.println("The name is " + context.getName() + " ,The cardId is " + context.getCardId());
    }
}
