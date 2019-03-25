package com.zhangj.ymm.thread.demo3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author zhangj
 * @date 2019/3/25
 */
public class MyClassLoader extends ClassLoader {
    private final static String DEFAULT_DIR = "D:\\baiduyun\\classloader1";
    private String dir = DEFAULT_DIR;
    private String classLoaderName;

    public MyClassLoader() {
        super();
    }

    public MyClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader classLoader) {
        super(classLoader);
        this.classLoaderName = classLoaderName;
    }

    /**
     * 传入com.zhangj.ymm.Test=>com/zhangj/ymm/Test
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("The class not found.");
        }
        //把文件转成数组
        byte[] classBytes = loadClassBytes(classFile);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException("load the class failed.");
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public String getDir() {
        return dir;
    }


    public void setDir(String dir) {
        this.dir = dir;
    }
}
