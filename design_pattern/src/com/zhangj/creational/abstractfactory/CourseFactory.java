package com.zhangj.creational.abstractfactory;

/**
 * @author zhangj
 * @date 2019/7/28
 */
public interface CourseFactory {
    Video getVideo();

    Article getArticle();
}
