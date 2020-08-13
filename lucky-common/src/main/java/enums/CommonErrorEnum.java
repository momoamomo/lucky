package enums;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import exception.IErrorEnum;

import java.util.Map;

/**
 * 通用错误枚举
 *
 * @author sunzhilin
 * @date 2020/8/12  11:57
 */
public enum  CommonErrorEnum implements IErrorEnum<String,String> {

    SYSTEM_ERROR("系统错误"),
    PARAMS_FORMAT_ERROR("参数格式错误"),
    LACK_PARAMS("缺少参数");
    /**
     * 错误描述
     */
    private String errMsg;

    private static ImmutableMap<String,CommonErrorEnum> map;

    CommonErrorEnum(String errMsg){
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
