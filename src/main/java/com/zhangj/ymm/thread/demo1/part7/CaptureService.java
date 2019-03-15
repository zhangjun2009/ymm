package com.zhangj.ymm.thread.demo1.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangj
 * @date 2019/2/20
 * @description: TODO
 */
public class CaptureService {
    private final static LinkedList<Control> CONTROLS = new LinkedList<>();

    public static void main(String[] args) {
        List<Thread> worker = new ArrayList<>();
        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10").stream()
                .map(CaptureService::createThread)
                .forEach(t -> {
                    t.start();
                    worker.add(t);
                });
        worker.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("All of capture work finished.").ifPresent(System.out::println);
    }

    private static Thread createThread(String name) {
        return new Thread(() -> {
            synchronized (CONTROLS) {
                while (CONTROLS.size() >= 5) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }
            Optional.of("The Worker [" + Thread.currentThread().getName() + "] is working......").ifPresent(System.out::println);
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CONTROLS) {
                Optional.of("The Worker [" + Thread.currentThread().getName() + "] is end......").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        }, name);
    }

    static class Control {

    }
}
