package com.zhangj.creational.prototype;

import java.text.MessageFormat;

/**
 * @author zhangj
 * @date 2019/8/1
 */
public class MailUtil {
    public static void sendMail(Mail mail) {
        String content = "向{0}同学,邮件地址:{1},邮件内容:{2}发送邮件成功.";
        System.out.println(MessageFormat.format(content, mail.getName(), mail.getAddress(), mail.getContent()));
    }

    public static void saveOriginalMailRecord(Mail mail) {
        System.out.println("存储originalMail记录,originalMail:" + mail.getContent());
    }
}
