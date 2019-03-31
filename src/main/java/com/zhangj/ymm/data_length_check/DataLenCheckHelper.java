package com.zhangj.ymm.data_length_check;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author zhangj
 * @date 2019/3/29
 */
public class DataLenCheckHelper {

    public static void checkAttributeValueLen(Object obj) throws Exception {
        if (null != obj) {
            // 得到class
            Class cls = obj.getClass();
            System.out.println("校验对象中参数的数据长度是否符合要求,校验对象:" + cls.getName());
            // 得到所有属性
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                // 遍历
                try {
                    // 得到属性
                    Field field = fields[i];
                    Annotation[] anns = field.getAnnotations();
                    ParamLength dataLen = null;
                    for (Annotation ann : anns) {
                        if (ann instanceof ParamLength) {
                            dataLen = (ParamLength) ann;
                        }
                    }

                    // 判断该属性是否有校验数据长度的注解
                    if (null != dataLen) {
                        // 打开私有访问
                        field.setAccessible(true);
                        // 获取属性
                        String name = field.getName();
                        // 获取属性值
                        Object value = field.get(obj);
                        // 指定的长度
                        int eq = dataLen.eq();
                        int gte = dataLen.gte();
                        int lte = dataLen.lte();

                        // String
                        if (null != value && value instanceof String) {
                            String data = (String) value;
                            int length = data.length();
                            if (length != eq) {
                                System.out.print("对象:" + cls.getName() + "中存在不符合条件的参数,参数名:" + name + "参数值:" + data + "指定的数据长度:" + eq + "实际长度:" + length
                                        + ",不符合条件");
                                throw new Exception();
                            }
                        } else {
                            Long data = (Long) value;
                            if (data < gte || data > lte) {
                                System.out.print("对象:" + cls.getName() + "中存在不符合条件的参数,参数名:" + name + "参数值MIN:" + gte + ",参数值MAX:" + lte + ",实际大小:" + data
                                        + ",不符合条件");
                                throw new Exception();
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


     /*if (null != value && value instanceof String) {
        String data = (String) value;
        int vaLen = data.getBytes("utf-8").length;
        if (vaLen != len) {
            throw new IllegalArgumentException("paramer:" + name + "," +
                    "value:" + data + ",Specifies the length of the data:" + len + "," +
                    "the actual length of the length of the data:" + vaLen);
        }
    } else {
        Long data = (Long) value;
        if (data < gte || data > lte) {
            throw new IllegalArgumentException("paramer:" + name + "min:" + gte + ",max:" + lte + "" +
                    ",actual:" + data);
        }
    }*/
}

