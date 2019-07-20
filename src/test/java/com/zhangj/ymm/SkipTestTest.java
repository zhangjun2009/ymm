package com.zhangj.ymm;

import com.zhangj.ymm.threadpool.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangj
 * @date 2019/7/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkipTestTest {
    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {

        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();

        Thread.currentThread().join();
    }
}