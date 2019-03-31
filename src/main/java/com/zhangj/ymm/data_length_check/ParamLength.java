package com.zhangj.ymm.data_length_check;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangj
 * @date 2019/3/29
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamLength {
    int gte();

    int eq();

    int lte();
}
