package com.zhangj.creational.iterator;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public interface CourseIterator {
    Course nextCourse();

    boolean isLastCourse();
}
