package com.zhangj.ymm.jdk.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangj
 * @date 2019/7/11
 */
public class Test {
    public static void main(String[] args) throws IOException {
        // 15个字节大小的缓冲区
        ByteBuffer b = ByteBuffer.allocate(15);
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        for (int i = 0; i < 10; i++) {
            // 存入10个字节数据
            b.put((byte) i);
        }
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        b.flip(); // 重置position
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        for (int i = 0; i < 5; i++) {
            System.out.print(b.get());
        }
        System.out.println();
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        b.flip();
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());

    }

    public static void nioCopyFile(String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        //读文件通道
        FileChannel readChannel = fis.getChannel();
        //写文件通道
        FileChannel writeChannel = fos.getChannel();
        //申请缓存
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            //读入数据
            int len = readChannel.read(byteBuffer);
            if (len == -1) {
                break;
            }
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
        }
        readChannel.close();
        writeChannel.close();
    }
}
