package com.zhangj.ymm.jdk;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhangj
 * @date 2019/5/14
 */
public class VoidTest {
    public static void main(String[] args) {
        use2();
    }

    private static void use1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Void> submit = executorService.submit(() -> null);
    }

    private static void use2() {
        HashMap<String, Void> hashMap = new HashMap<>();
        hashMap.put("1", null);
        hashMap.put("2", null);
        hashMap.put("1", null);
        hashMap.keySet().stream().forEach(System.out::println);
    }
}
