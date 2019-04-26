package com.zhangj.ymm.jdk;

import java.util.Objects;
import java.util.Optional;

/**
 * @author zhangj
 * @date 2019/4/26
 */
public class ObjectsTest {
    public static void main(String[] args) {
        //equalsTest();
        //deepEqualsTest();
        //hashCodeTest();
        //toStringDefault();
        //compareTest();
        requireNonNullTest();
    }

    private static void requireNonNullTest() {
        //Optional.of(Objects.requireNonNull(null)).ifPresent(System.out::println);
        //Optional.of(Objects.requireNonNull(null, "value is null")).ifPresent(System.out::println);
        Optional.of(Objects.requireNonNull(null, "111")).ifPresent(System.out::println);
    }

    private static void equalsTest() {
        Optional.of(Objects.equals(1, 1)).ifPresent(System.out::println);
        Optional.of(Objects.equals(null, null)).ifPresent(System.out::println);
        Optional.of(Objects.equals(null, 1)).ifPresent(System.out::println);
        Optional.of(Objects.equals(1, null)).ifPresent(System.out::println);
        Optional.of(Objects.equals("a", "a")).ifPresent(System.out::println);
    }

    private static void deepEqualsTest() {
        String a = "1";
        String b = "1";
        String c = new String("1");
        String d = new String("1");
        Object obj1 = new Object();
        Object obj2 = new Object();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 3, 2};
        Optional.of(Objects.deepEquals(1, 1)).ifPresent(System.out::println);
        Optional.of(Objects.deepEquals("1", "1")).ifPresent(System.out::println);
        Optional.of(Objects.deepEquals(a, b)).ifPresent(System.out::println);
        Optional.of(Objects.deepEquals(c, d)).ifPresent(System.out::println);
        Optional.of(Objects.deepEquals(obj1, obj2)).ifPresent(System.out::println);
        Optional.of(Objects.deepEquals(arr1, arr2)).ifPresent(System.out::println);
    }

    private static void hashCodeTest() {
        Optional.of(Objects.hashCode(null)).ifPresent(System.out::println);
        Optional.of(Objects.hashCode("12")).ifPresent(System.out::println);
    }

    private static void toStringDefault() {
        Optional.of(Objects.toString("11", "null")).ifPresent(System.out::println);
        Optional.of(Objects.toString(null, "null")).ifPresent(System.out::println);
    }

    private static void compareTest() {
        Optional.of(Objects.compare(1, 2, Integer::compareTo)).ifPresent(System.out::println);
    }
}
