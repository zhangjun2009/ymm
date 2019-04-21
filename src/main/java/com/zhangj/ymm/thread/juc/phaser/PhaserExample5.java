package com.zhangj.ymm.thread.juc.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangj
 * @date 2019/4/21
 */
public class PhaserExample5 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(5);
        for (int i = 0; i < 4; i++) {
            new ArriveTask(phaser, i).start();
        }
        phaser.arriveAndAwaitAdvance();
        System.out.println("the phase one working finished.");
    }

    static class ArriveTask extends Thread {
        private final Phaser phaser;

        ArriveTask(Phaser phaser, int no) {
            super(String.valueOf(no));
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(getName() + " start working.");
            sleeps();
            System.out.println(getName() + " the phase one is running.");
            phaser.arrive();
            sleeps();
            System.out.println(getName() + " keep to do other thing.");
        }
    }

    private static void sleeps() {
        try {
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
