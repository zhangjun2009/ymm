package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 * 接受异步消息的主动方法
 */
public interface ActiveObject {
    Result makeString(int count, char fillChar);

    void displayString(String text);
}
