package com.zhangj.ymm.jdk;

import org.junit.Test;

/**
 * @author zhangj
 * @date 2019/5/13
 */
public class IntegerTestTest {

    @Test
    public void test() {
        System.out.println(Integer.BYTES);
    }

    @Test
    public void testToString() {
        System.out.println(Integer.toString(892, 9));
    }

    @Test
    public void testToUnsignedLong() {
        System.out.println(Integer.toUnsignedLong(11));
    }

    @Test
    public void testReverseBytes() {
        System.out.println(Integer.toBinaryString(Integer.reverseBytes(8)));
    }

    @Test
    public void toHexString() {
        System.out.println(Integer.toHexString(32));
    }

    @Test
    public void reverseBytes() {
        System.out.println(Integer.signum(12));
    }

    @Test
    public void exchange1() {
        int a = 1, b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    @Test
    public void exchange2() {
        int a = 1, b = 3, c = 0;
        c = a;
        a = b;
        b = c;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    @Test
    public void exchange3() {
        int a = 1, b = 3, c = 0;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}