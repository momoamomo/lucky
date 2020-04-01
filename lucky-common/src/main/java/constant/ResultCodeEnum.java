package constant;

import lombok.Getter;

/**
 * @author sunzhilin
 * @date 2020/3/25  10:43
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(true, 20000, "成功"),
    UNKNOWN_ERROR(false, 20001, "未知错误"),
    PARAM_ERROR(false, 20002,"参数错误"),
    NO_AUTH(false, 20003,"没有权限"),
    BUSINESS_ERROR(false, 20004, "业务逻辑错误");



    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }


}
