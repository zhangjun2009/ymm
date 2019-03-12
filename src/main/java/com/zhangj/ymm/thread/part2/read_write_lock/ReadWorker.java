package com.zhangj.ymm.thread.part2.read_write_lock;

/**
 * @author zhangj
 * @date 2019/3/9
 */
public class ReadWorker extends Thread {
    private final ShardData data;

    public ReadWorker(ShardData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
