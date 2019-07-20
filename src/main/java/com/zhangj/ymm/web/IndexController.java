package com.zhangj.ymm.web;

import com.zhangj.ymm.threadpool.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangj
 * @date 2019/5/5
 */
@Controller
@EnableAutoConfiguration
public class IndexController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/")
    public String index() {
        asyncService.executeAsync();
        return "index";
    }
}
