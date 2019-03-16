package com.zhangj.ymm.thread.demo2.thread_local.thread_local_usage;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class QueryFromHttpAction {

    public void execute() {
        try {
            Thread.sleep(1000);
            Context context = ActionContext.getActionContext().getContext();
            String name = context.getName();
            String cardId = getCardIdFromName(name);
            context.setCardId(cardId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCardIdFromName(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "34252222852" + Thread.currentThread().getId();
    }
}
