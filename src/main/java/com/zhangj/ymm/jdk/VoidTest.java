package com.zhangj.ymm.jdk;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhangj
 * @date 2019/5/14
 */
public class VoidTest {
    public static void main(String[] args) {
        use2();
    }

    private static void use1() {
        List<String> list = Lists.newArrayList("11".split(","));
        System.out.println(list);
    }

    private static void use2() {
        HashMap<String, Void> hashMap = new HashMap<>();
        hashMap.put("1", null);
        hashMap.put("2", null);
        hashMap.put("1", null);
        hashMap.keySet().stream().forEach(System.out::println);
    }
}
