package com.zhangj.ymm.thread.builder;


import lombok.Data;

import java.util.Date;

/**
 * @author zhangj
 * @date 2019/3/8
 */
@Data
public class User {
    private String name;
    private int age;
    private String addr;
    private String interest;
    private Date birthday;

    public User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.addr = builder.addr;
        this.interest = builder.interest;
        this.birthday = builder.birthday;
    }

    public static class Builder {
        private String name;
        private int age;
        private String addr;
        private String interest;
        private Date birthday;

        public Builder(String name, int age, String addr) {
            this.name = name;
            this.age = age;
            this.addr = addr;
        }

        public Builder interest(String interest) {
            this.interest = interest;
            return this;
        }

        public Builder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
