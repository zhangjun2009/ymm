package com.zhangj.ymm.data_length_check;

/**
 * @author zhangj
 * @date 2019/3/29
 */
public class Test {
    public static void main(String[] args) {
        try {
            TestObj testObj = new TestObj("12345", "11223344553");
            DataLenCheckHelper.checkAttributeValueLen(testObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
