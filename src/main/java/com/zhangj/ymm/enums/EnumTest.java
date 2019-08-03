package com.zhangj.ymm.enums;

import java.util.EnumSet;

/**
 * @author zhangj
 * @date 2019/8/1
 */
public class EnumTest {
    public static void main(String[] args) {
        EnumSet<EnumColor> enumColors = EnumSet.allOf(EnumColor.class);
        for (EnumColor color : enumColors) {
            System.out.println(color);
        }
    }
}
