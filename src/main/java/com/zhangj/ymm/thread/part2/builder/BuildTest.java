package com.zhangj.ymm.thread.part2.builder;

import java.util.Date;

/**
 * @author zhangj
 * @date 2019/3/8
 */
public class BuildTest {
    public static void main(String[] args) {
        User user = new User.Builder("zhangj", 12, "nanjing").birthday(new Date()).build();
        System.out.println(user);
    }
}
