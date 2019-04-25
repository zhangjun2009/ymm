package com.zhangj.ymm.work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zhangj
 * @date 2019/3/15
 */
public class Test {
    public static void main(String[] args) {
        User user = new User(1, "libai");
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        String str = "{\"s_id\":1,\"user_name\":\"libai\"}";
        User object = JSON.parseObject(str, User.class);
        System.out.println(object);
    }

    @Data
    @Accessors(fluent = true)
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class User {
        @JSONField(name = "s_id")
        private int sId;

        @JSONField(name = "user_name")
        private String userName;
    }

}
