package com.zhangj.ymm.thread_pool;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @author zhangj
 * @date 2019/1/17
 * @description: 平台前线forkjoin刷数据task
 */
@Slf4j
public class InfoCustomerRecursiveAction extends RecursiveAction {
    private final int start;

    private final int end;

    private final List<Integer> data;

    private final int limit;


    public InfoCustomerRecursiveAction(int start, int end, List<Integer> data, int limit) {
        this.start = start;
        this.end = end;
        this.data = data;
        this.limit = limit;

    }

    @Override
    protected void compute() {
        if ((end - start) <= limit) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("working ..............");
        } else {
            int mid = (start + end) / 2;
            InfoCustomerRecursiveAction left = new InfoCustomerRecursiveAction(start, mid, data, limit);
            InfoCustomerRecursiveAction right = new InfoCustomerRecursiveAction(mid, end, data, limit);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }
    }
}
