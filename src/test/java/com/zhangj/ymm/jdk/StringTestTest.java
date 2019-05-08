package com.zhangj.ymm.jdk;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

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
    public void testCharAt() {
        String str = new String(new char[]{'1', '2', '3', '4', '5', '6'});
        System.out.println("result:" + str.charAt(0));
        System.out.println("result:" + str.charAt(1));
    }

    @Test
    public void arrayCopyTest() {
        int[] sourceArray = new int[]{1, 2, 3, 4, 5, 6};
        int[] destArray = new int[10];
        System.arraycopy(sourceArray, 1, destArray, 0, 2);
        Arrays.stream(destArray).forEach(System.out::println);
    }

    @Test
    public void testCodePointAt() {
        String str = new String(new char[]{'a', 'b', 'c', 'd', 'e', 'f'});
        System.out.println("result:" + str.codePointAt(0));
    }

    @Test
    public void testCodePointBefore() {
        String str = new String(new char[]{'a', 'b', 'c', 'd', 'e', 'f'});
        System.out.println("result:" + str.codePointBefore(1));
    }

    @Test
    public void testCodePointCount() {
        String str = new String(new char[]{'a', 'b', 'c', 'd', 'e', 'f'});
        System.out.println("result:" + str.codePointCount(0, 2));
    }

    @Test
    public void compareTo() {
        String str1 = "b";
        String str2 = "bcdef";
        System.out.println(str1.compareTo(str2));
    }

    @Test
    public void compareToIgnoreCase() {
        String str1 = "B";
        String str2 = "bcdef";
        System.out.println(str1.compareToIgnoreCase(str2));
    }

    @Test
    public void regionMatches() {
        String str1 = "abcdef";
        String str2 = "bcdef";
        System.out.println(str1.regionMatches(1, str2, 0, 2));
    }

    @Test
    public void startsWith() {
        String str = "abcdef";
        System.out.println(str.startsWith("a"));
    }

    @Test
    public void indexOf() {
        String str = "abadef";
        System.out.println(str.indexOf(97));
        System.out.println(str.indexOf("a"));
    }

    @Test
    public void getChars() {
        String str = "abadef";
        char[] dist = new char[10];
        str.getChars(0, 2, dist, 0);
        for (char ch : dist) {
            System.out.println(ch);
        }
    }

    @Test
    public void lastIndexOf() {
        String str = "abadef";
        System.out.println(str.lastIndexOf("a"));
    }

    @Test
    public void format() {
        Date date=new Date();
        System.out.println(String.format("%tF %tT",date,date));
    }

}