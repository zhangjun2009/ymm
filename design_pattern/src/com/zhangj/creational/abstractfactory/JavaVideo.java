package com.zhangj.creational.abstractfactory;

/**
 * @author zhangj
 * @date 2019/7/28
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制java视频");
    }
}
