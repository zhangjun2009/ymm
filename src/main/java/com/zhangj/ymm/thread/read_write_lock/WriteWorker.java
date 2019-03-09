package com.zhangj.ymm.thread.read_write_lock;

import java.util.Random;

/**
 * @author zhangj
 * @date 2019/3/9
 */
public class WriteWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());
    private final ShardData data;
    private final String filler;
    private int index = 0;


    public WriteWorker(ShardData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}
