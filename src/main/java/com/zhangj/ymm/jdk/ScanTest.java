package com.zhangj.ymm.jdk;

/**
 * @author zhangj
 * @date 2019/5/7
 */
public class ScanTest {
    public static void main(String[] args) {
        scans:
        {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 4) {
                    break scans;
                }
            }
        }
    }
}
