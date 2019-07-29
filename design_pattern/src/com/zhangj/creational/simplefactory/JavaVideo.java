package com.zhangj.creational.simplefactory;

/**
 * @author zhangj
 * @date 2019/7/27
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("生产java视频");
    }
}
