package com.zhangj.ymm.thread.juc.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/21
 */
public class PhaserExample2 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);

        for (int i = 1; i < 6; i++) {
            new Athletes(i, phaser).start();
        }
    }

    static class Athletes extends Thread {
        private final int no;
        private final Phaser phaser;

        Athletes(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                System.out.println(no + ": start running......");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(no + ": end running......");

                phaser.arriveAndAwaitAdvance();

                System.out.println(no + ": start bicycle......");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(no + ": end bicycle......");

                phaser.arriveAndAwaitAdvance();

                System.out.println(no + ": start long jump......");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(no + ": end long jump......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
