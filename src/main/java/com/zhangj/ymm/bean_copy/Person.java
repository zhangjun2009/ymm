package com.zhangj.ymm.bean_copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhangj
 * @date 2019/4/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;
}
