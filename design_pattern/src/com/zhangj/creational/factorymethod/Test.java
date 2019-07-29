package com.zhangj.creational.factorymethod;

/**
 * @author zhangj
 * @date 2019/7/27
 */
public class Test extends JavaVideo {
    public static void main(String[] args) {
        VideoFactory javaVideoFactory = new JavaVideoFactory();
        Video video = javaVideoFactory.create();
        video.produce();
    }
}
