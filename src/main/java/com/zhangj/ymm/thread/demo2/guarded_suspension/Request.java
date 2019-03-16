package com.zhangj.ymm.thread.demo2.guarded_suspension;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class Request {
    private final String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
