package com.zhangj.ymm.hutool.clone;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangj
 * @date 2019/7/30
 */
@Data
public class Cat implements Cloneable<Cat>, Serializable {
    private String name = "miaomiao";
    private int age = 2;
    private Dog dog = new Dog();

    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}
