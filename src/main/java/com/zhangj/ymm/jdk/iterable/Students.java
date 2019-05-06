package com.zhangj.ymm.jdk.iterable;

import java.util.Iterator;

/**
 * @author zhangj
 * @date 2019/5/6
 */
public class Students implements Iterable<Student> {
    private Student[] students;

    public Students(int size) {
        students = new Student[size];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i, "学生" + i);
        }
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements Iterator<Student> {
        //当前迭代下标
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.length;
        }

        @Override
        public Student next() {
            return students[index++];
        }
    }
}
