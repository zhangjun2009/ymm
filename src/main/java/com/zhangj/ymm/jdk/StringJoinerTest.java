package com.zhangj.ymm.jdk;

import java.util.StringJoiner;

/**
 * @author zhangj
 * @date 2019/5/7
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner sj1 = new StringJoiner("/");
        sj1.add("1").add("2");
        StringJoiner sj2 = new StringJoiner("%");
        sj2.add("1").add("2");
        sj1.merge(sj2);
        StringJoiner sj3 = new StringJoiner("", "[", "]");
        sj3.add("1").add("2").add("3");
        System.out.println(sj3);
    }
}
