package com.zhangj.creational.iterator;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public interface CourseAggregate {
    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator getCourseIterator();
}
