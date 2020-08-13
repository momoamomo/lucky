package com.szl.lucky.web.enums;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import enums.CommonErrorEnum;
import exception.IErrorEnum;

import java.util.Map;

/**
 * @author sunzhilin
 * @date 2020/3/30  10:22
 */
public enum LuckyWebErrorEnum implements IErrorEnum<String,String > {

    userNotExits("用户不存在！"),
    wrongPasswordFalse("用户名或密码错误"),
    passwordFalse("密码错误"),
    USER_EXSIST("用户已存在,请核实");

    /**
     * 错误描述
     */
    private String errMsg;

    private static ImmutableMap<String, CommonErrorEnum> map;

    LuckyWebErrorEnum(String errMsg){
        this.errMsg =errMsg;
    }

    static {
        Map<String, CommonErrorEnum> tmp = Maps.newHashMap();
        for(CommonErrorEnum item : CommonErrorEnum.values()){
            tmp.put(item.name(),item);
        }
        map = ImmutableMap.<String, CommonErrorEnum>builder().putAll(tmp).build();
    }

    /**
     * 根据枚举名获取枚举值，区别于valueOf方法
     * @param name
     * @return
     */
    public static CommonErrorEnum getByName(String name){
        return map.get(name);
    }

    @Override
    public String getErrCode(){
        return name();
    }

    @Override
    public String getErrMsg(){
        return errMsg;
    }
}
