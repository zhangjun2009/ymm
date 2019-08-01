package com.zhangj.creational.builder;

/**
 * @author zhangj
 * @date 2019/7/31
 */
public class Cat {
    public static void main(String[] args) {
        Cat cat = new CatBuilder().buildAge(1).buildName("zzz").buildSex("man").build();
        System.out.println(cat.toString());
    }

    private String name;
    private String sex;
    private int age;

    public Cat(CatBuilder catBuilder) {
        this.name = catBuilder.name;
        this.sex = catBuilder.sex;
        this.age = catBuilder.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class CatBuilder {
        private String name;
        private String sex;
        private int age;

        public CatBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public CatBuilder buildSex(String sex) {
            this.sex = sex;
            return this;
        }

        public CatBuilder buildAge(int age) {
            this.age = age;
            return this;
        }

        public Cat build() {
            return new Cat(this);
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
