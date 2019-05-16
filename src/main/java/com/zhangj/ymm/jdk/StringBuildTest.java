package com.zhangj.ymm.jdk;

/**
 * @author zhangj
 * @date 2019/5/16
 */
public class StringBuildTest {
    public static void main(String[] args) {
        System.out.println(resever("abcde"));
    }

    private static char[] resever(String str) {
        char[] chars = str.toCharArray();
        int n = str.length() - 1;
        for (int j = n / 2; j >= 0; j--) {
            int k = n - j;
            char a = chars[j];
            char b = chars[k];
            chars[j] = b;
            chars[k] = a;
        }
        return chars;
    }
}
