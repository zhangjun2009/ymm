package com.zhangj.ymm.thread.demo2.producer_consumer;

/**
 * @author zhangj
 * @date 2019/3/17
 */
public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
