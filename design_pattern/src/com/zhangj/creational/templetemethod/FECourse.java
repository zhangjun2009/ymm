package com.zhangj.creational.templetemethod;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class FECourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("提供课程的前端代码");
        System.out.println("提供课程的图片等多媒体素材");
    }
}
