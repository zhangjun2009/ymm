package com.zhangj.creational.simplefactory;

/**
 * @author zhangj
 * @date 2019/7/27
 */
public class VideoFactory {

    public static Video create2(Class clazz) {
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }

    public static Video create1(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("php".equalsIgnoreCase(type)) {
            return new PhpVideo();
        }
        return null;
    }
}
