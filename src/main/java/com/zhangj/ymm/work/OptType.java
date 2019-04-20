package com.zhangj.ymm.work;

import java.util.Arrays;

/**
 * @author zhangj
 * @date 2019/3/18
 */
public enum OptType {
    ADD(1), UPDATE(2), DELETE(3);
    private final int code;

    OptType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static boolean isExistOptType(int code) {
        return Arrays.stream(OptType.values()).anyMatch(v -> v.getCode() == code);
    }

}
