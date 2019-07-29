package com.zhangj.creational.simplefactory;

/**
 * @author zhangj
 * @date 2019/7/27
 */
public class Test extends JavaVideo {
    public static void main(String[] args) {
//        Video video = new JavaVideo();
//        video.produce();
//        Video video = VideoFactory.create1("php");
//        if (video == null) {
//            return;
//        }
//        video.produce();
        Video video = VideoFactory.create2(JavaVideo.class);
        video.produce();
    }
}
