package com.zhangj.ymm.thread.demo3;

import java.util.Random;

/**
 * @author zhangj
 * @date 2019/3/24
 */
public class ClassActiveUse {
    public static void main(String[] args) throws ClassNotFoundException {
        //Obj obj = new Obj();
        //obj.hashCode();
        //System.out.println(Obj.salary);
        //Obj.printSalary();
        //Class.forName("com.zhangj.ymm.thread.demo3.Obj");
        //System.out.println(Child.age);
        //System.out.println(Child.salary);
        //Obj[] arrays = new Obj[10];
        //System.out.println(Test.name);
        System.out.println(Test.random);
    }
}

class Obj {
    public static long salary = 5000000;

    static {
        System.out.println("Obj will be initialization");
    }

    public static void printSalary() {
        System.out.println("===========obj==============");
    }
}

class Child extends Obj {
    public static long age = 5000000;

    static {
        System.out.println("Child will be initialization");
    }
}

class Test {
    public final static String name = "zhangj";
    public final static int random = new Random(System.currentTimeMillis()).nextInt(100);


    static {
        System.out.println("Test will be initialization");
    }
}


