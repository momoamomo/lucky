package com.szl.lucky.web.enums;

import util.BaseChecker;

/**
 * @author sunzhilin
 * @date 2020/8/13  14:44
 */
public enum UserInfoDeleteFlag {
    IS_DELETED(true, "已删除"),
    NO_DELETE(false, "未删除");

    /**
     * 编码
     */
    private final Boolean code;

    /**
     * 描述
     */
    private final String msg;

    UserInfoDeleteFlag(Boolean code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Boolean getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
