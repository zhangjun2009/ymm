package com.zhangj.creational.prototype;

/**
 * @author zhangj
 * @date 2019/8/1
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板!");
        for (int i = 0; i < 10; i++) {
            Mail mailTemp = (Mail) mail.clone();
            mailTemp.setName("姓名" + i);
            mailTemp.setAddress("地址" + i);
            mailTemp.setContent("success");
            MailUtil.sendMail(mailTemp);
        }
        MailUtil.saveOriginalMailRecord(mail);
    }
}
