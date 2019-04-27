package com.zhangj.ymm.jdk;

import lombok.ToString;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangj
 * @date 2019/4/26
 */
public class ReflectionUtilsTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        testAccessibleConstructor();
    }

    private static void testAccessibleConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor<User> constructor = ReflectionUtils.accessibleConstructor(User.class, int.class, String.class);
        User user = constructor.newInstance(30, "南京市鼓楼区");
        System.out.println(user);
    }

    @ToString
    private static class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @ToString
    private static class User extends Person {
        private int id;
        protected String addr;

        public User() {
        }

        public User(int id, String addr) {
            this.id = id;
            this.addr = addr;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }
    }
}
