package com.zhangj.ymm.thread.part1.part1;

/**
 * @author zhangj
 * @date 2019/3/12
 * 简单的多线程异步执行代码
 */
public class TryConcurrent {
    public static void main(String[] args) {
        new Thread("READ_THREAD") {
            @Override
            public void run() {
                readFromDateBase();
            }
        }.start();

        new Thread("WRITE_THREAD") {
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    public static void readFromDateBase() {
        try {
            println("Begin read database from db.");
            Thread.sleep(1000 * 10);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    public static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(2000 * 10L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void println(String s) {
        System.out.println(s);
    }
}
