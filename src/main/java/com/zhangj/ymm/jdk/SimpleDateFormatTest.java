package com.zhangj.ymm.jdk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangj
 * @date 2019/6/19
 */
public class SimpleDateFormatTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            int ii = i;
            new Thread(() -> {
                String s = "2019-05-" + ii;
                Date parse;
                try {
                    synchronized (SimpleDateFormatTest.class) {
                        parse = sdf.parse(s);
                    }
                    System.out.println(ii + ":" + parse.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
