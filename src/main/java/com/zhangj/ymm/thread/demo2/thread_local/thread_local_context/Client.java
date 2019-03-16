package com.zhangj.ymm.thread.demo2.thread_local.thread_local_context;

import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/3/16
 */
public class Client {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5).forEach(i -> new Thread(new ExecutionTask()).start());
    }
}
