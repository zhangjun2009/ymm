package com.zhangj.creational.iterator;

import java.util.List;

/**
 * @author zhangj
 * @date 2019/8/4
 */
public class CourseIteratorImpl implements CourseIterator {
    private List courseList;
    private int position;
    private Course course;

    public CourseIteratorImpl(List courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        course = (Course) courseList.get(position);
        position++;
        return course;
    }

    @Override
    public boolean isLastCourse() {
        if (position >= courseList.size()) {
            return true;
        }
        return false;
    }
}
