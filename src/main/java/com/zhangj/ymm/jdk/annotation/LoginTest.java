package com.zhangj.ymm.jdk.annotation;

import lombok.Builder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zhangj
 * @date 2019/5/17
 */
public class LoginTest {
    public static void main(String[] args) throws Exception {
        Method method = LoginTest.class.getMethod("login");
        boolean present = method.isAnnotationPresent(Login.class);
        if (present) {
            System.out.println("method have annotation.");
        } else {
            System.out.println("method do not have annotation.");
        }
        System.out.println("===============================");
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation ann : annotations) {
            if (ann instanceof Login) {
                System.out.println(((Login) ann).passWord());
                System.out.println(((Login) ann).userName());
            }
        }
    }

    @Builder
    @Login
    public void login() {
        System.out.println();
    }
}
