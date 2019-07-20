package com.zhangj.ymm.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhangj
 * @date 2019/7/16
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Async("asyncServiceExecutor")
    @Override
    public void executeAsync() {
        logger.info("start executeAsync");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("end executeAsync");
    }
}
