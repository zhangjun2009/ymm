package com.zhangj.ymm.thread.demo2.read_write_lock;

/**
 * @author zhangj
 * @date 2019/3/9
 */
public class ReadWriteLocalClient {
    public static void main(String[] args) {
        ShardData shardData = new ShardData(10);
        new ReadWorker(shardData).start();
        new ReadWorker(shardData).start();
        new WriteWorker(shardData, "qwertyu").start();
        new WriteWorker(shardData, "QWERTYU").start();
    }
}
