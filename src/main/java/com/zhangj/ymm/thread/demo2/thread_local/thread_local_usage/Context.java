package com.zhangj.ymm.thread.demo2.thread_local.thread_local_usage;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class Context {

    private String name;
    private String cardId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}
