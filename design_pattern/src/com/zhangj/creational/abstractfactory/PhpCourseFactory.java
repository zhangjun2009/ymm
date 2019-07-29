package com.zhangj.creational.abstractfactory;

/**
 * @author zhangj
 * @date 2019/7/28
 */
public class PhpCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PhpVideo();
    }

    @Override
    public Article getArticle() {
        return new PhpArticle();
    }
}
