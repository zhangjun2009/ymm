package com.zhangj.ymm.hutool.convert;

import cn.hutool.core.convert.Convert;
import com.zhangj.ymm.hutool.clone.Cat;

import java.util.Date;

/**
 * @author zhangj
 * @date 2019/7/30
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        String s = Convert.toStr(a);
        long[] b = {1, 2, 3, 4, 5};
        String s1 = Convert.toStr(b);
        System.out.println(s1);
        Cat cat = new Cat();
        cat.setName("qqqq");
        cat.setAge(12);
        Person person = Convert.convert(Person.class, cat);
        System.out.println(person);
        Date date = Convert.toDate("2019-10-10");
        System.out.println(date);
    }
}
