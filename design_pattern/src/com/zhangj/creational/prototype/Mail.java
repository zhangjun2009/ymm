package com.zhangj.creational.prototype;

/**
 * @author zhangj
 * @date 2019/8/1
 */
public class Mail implements Cloneable {
    private String name;
    private String address;
    private String content;

    public Mail() {
        System.out.println("mail class constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
