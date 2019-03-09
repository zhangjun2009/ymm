package com.zhangj.ymm.thread.builder;

import com.zhangj.ymm.thread.builder.User.*;

import java.util.Date;

/**
 * @author zhangj
 * @date 2019/3/8
 */
public class BuildTest {
    public static void main(String[] args) {
        User user = new Builder("zhangj", 12, "nanjing").birthday(new Date()).build();
        System.out.println(user);
    }
}
