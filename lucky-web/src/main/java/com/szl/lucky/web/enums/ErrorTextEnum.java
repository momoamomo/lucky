package com.szl.lucky.web.enums;

/**
 * @author sunzhilin
 * @date 2020/8/13  11:11
 */
public enum ErrorTextEnum {
    userNotExits("用户不存在！"),
    wrongPasswordFalse("用户名或密码错误"),
    passwordFalse("密码错误");

    public final String text;

    ErrorTextEnum(String text){
        this.text = text;
    }
}
