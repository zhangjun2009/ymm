package com.zhangj.ymm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class YmmApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmmApplication.class, args);
    }

}
