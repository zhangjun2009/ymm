package com.zhangj.ymm.thread.demo2.Immutable_object;

import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/3/12
 */
public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("zhangj", "nanjing");
        IntStream.rangeClosed(1, 5).forEach(i ->
                new UsePersonThread(person).start()
        );
    }
}
