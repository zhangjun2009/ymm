package com.zhangj.creational.templetemethod;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class DesignPatternCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("提供java课程源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
