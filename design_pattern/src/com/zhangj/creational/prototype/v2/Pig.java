package com.zhangj.creational.prototype.v2;

import java.util.Date;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class Pig implements Cloneable {
    private String name;
    private Date birthDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
