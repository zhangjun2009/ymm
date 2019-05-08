package com.zhangj.ymm.jdk.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangj
 * @date 2019/5/7
 */
public class BooleanTestTest {
    public static void main(String[] args) {
        ArrayList<HashMap<Object, Object>> list = new ArrayList<>();
        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("1","1");
        map1.put("2","2");
        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put("1","3");
        map2.put("2","4");
        list.add(map1);
        list.add(map2);
        List<Object> collect = list.stream().flatMap(i -> i.values().stream()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void compare() {
        System.out.println(Boolean.compare(true, false));
        System.out.println(Boolean.compare(true, true));
        System.out.println(Boolean.compare(false, true));
        System.out.println(Boolean.compare(false, false));
    }

    @Test
    public void logical() {
        System.out.println(Boolean.logicalAnd(1 > 0, 1 > 2));

    }
}