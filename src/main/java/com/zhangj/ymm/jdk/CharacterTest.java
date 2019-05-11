package com.zhangj.ymm.jdk;

/**
 * @author zhangj
 * @date 2019/5/8
 */
public class CharacterTest {
    public static void main(String[] args) {
        Character.UnicodeBlock.of('a');
    }

    private static char testMinValue() {
        return Character.MAX_VALUE;
    }
}
