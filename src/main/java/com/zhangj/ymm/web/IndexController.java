package com.zhangj.ymm.web;

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

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
