package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public class ActiveObjectClient {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakeStringClientThread("zhangj", activeObject).start();
        new MakeStringClientThread("chenwenqian", activeObject).start();
        new DisplayClientThread("wangg", activeObject).start();
    }
}
