package com.zhangj.ymm.jdk;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/5/5
 */
public class StringTestTest {

    @Test
    public void build1() {
        String str = new String();
        System.out.println(str);
    }

    @Test
    public void build2() {
        String str = new String("test");
        System.out.println(str);
    }

    @Test
    public void build3() {
        String str = new String(new char[]{'1', '2'});
        System.out.println("result:" + str);
    }

    @Test
    public void build4() {
        String str = new String(new char[]{'1', '2', '3', '4', '5', '6'}, 1, 2);
        System.out.println("result:" + str);
    }

    @Test
    public void arrayCopyTest() {
        int[] sourceArray = new int[]{1, 2, 3, 4, 5, 6};
        int[] destArray = new int[10];
        System.arraycopy(sourceArray, 1, destArray, 0, 2);
        Arrays.stream(destArray).forEach(System.out::println);
    }
}