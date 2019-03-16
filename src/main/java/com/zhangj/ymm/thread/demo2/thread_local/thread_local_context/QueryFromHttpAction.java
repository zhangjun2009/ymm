package com.zhangj.ymm.thread.demo2.thread_local.thread_local_context;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class QueryFromHttpAction {

    public void execute(Context context) {
        try {
            Thread.sleep(1000);
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
