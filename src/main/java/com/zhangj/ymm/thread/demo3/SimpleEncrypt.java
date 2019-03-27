package com.zhangj.ymm.thread.demo3;


/**
 * @author zhangj
 * @date 2019/3/26
 */
public class SimpleEncrypt {
    private static final String plain = "Hello world!";
    private static final byte ENCRYPT_FACTOR = (byte) 0xff;

    public static void main(String[] args) {
        byte[] bytes = plain.getBytes();
        byte[] encrypt = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encrypt[i] = (byte) (bytes[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println(new String(encrypt));
    }
}
