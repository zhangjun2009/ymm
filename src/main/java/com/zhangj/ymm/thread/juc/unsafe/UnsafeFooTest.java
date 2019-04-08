package com.zhangj.ymm.thread.juc.unsafe;

import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;

/**
 * @author zhangj
 * @date 2019/4/6
 */
public class UnsafeFooTest {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = UnsafeTest.getUnsafe();
        Simple simple = (Simple) unsafe.allocateInstance(Simple.class);
        System.out.println(simple.get());
        Simple.class.newInstance();
        Class.forName("com.zhangj.ymm.thread.juc.unsafe.UnsafeFooTest$Simple");
        System.out.println(simple.getClass());
        System.out.println(simple.getClass().getClassLoader());
        System.out.println("================================================");
        Guard guard = new Guard();
        guard.work();
        Field field = guard.getClass().getDeclaredField("ACCESS_ALLOW");
        unsafe.putInt(guard, unsafe.objectFieldOffset(field), 42);
        guard.work();
        System.out.println("================================================");
        byte[] bytes = loadClassContent();
    }

    private static byte[] loadClassContent() throws Exception {
        File file = new File("D:\\ymm\\target\\classes\\com\\zhangj\\ymm\\thread\\juc\\unsafe\\A.class");
        FileInputStream fis = new FileInputStream(file);
        byte[] content = new byte[(int) file.length()];
        fis.read(content);
        fis.close();
        return content;
    }

    static class Guard {
        private int ACCESS_ALLOW = 1;

        private boolean allow() {
            return 42 == ACCESS_ALLOW;
        }

        private void work() {
            if (allow()) {
                System.out.println("i am working from access!");
            }
        }
    }

    static class Simple {
        private long l;

        public Simple() {
            this.l = 1;
            System.out.println("Simple init finished.");
        }

        public long get() {
            return l;
        }
    }
}
