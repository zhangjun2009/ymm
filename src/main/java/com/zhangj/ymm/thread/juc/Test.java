package com.zhangj.ymm.thread.juc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangj
 * @date 2019/3/27
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        map1.put("id", 45);
        map2.put("id", 8);
        map3.put("id", 9);
        List<Map<String, Integer>> list = Arrays.asList(map1, map2, map3);
        list.sort(new idComparator());
        System.out.println(list);
        list.stream().sorted(Comparator.comparing(map -> map.get("id")));
        System.out.println(list);
    }

    public static class idComparator implements Comparator<Map<String, Integer>> {
        @Override
        public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
            long l = Integer.valueOf(o2.get("id").toString())
                    - Integer.valueOf(o1.get("id").toString());
            return (int) l;
        }
    }
}
