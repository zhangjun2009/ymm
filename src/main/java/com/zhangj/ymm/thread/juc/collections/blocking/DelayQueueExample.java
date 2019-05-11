package com.zhangj.ymm.thread.juc.collections.blocking;

import java.util.concurrent.DelayQueue;

/**
 * @author zhangj
 * @date 2019/5/11
 */
public class DelayQueueExample {
    public static <T extends DelayQueue> DelayQueue create() {
        return new DelayQueue();
    }
}
