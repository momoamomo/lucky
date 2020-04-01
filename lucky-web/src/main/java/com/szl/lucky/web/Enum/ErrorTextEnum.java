package com.szl.lucky.web.Enum;

/**
 * @author sunzhilin
 * @date 2020/3/30  10:22
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
