package base;

import java.util.HashMap;
import java.util.Map;

import constant.ResultCodeEnum;
import lombok.Data;

/**
 * @author sunzhilin
 * @date 2020/3/25  10:31
 */
@Data
public class LuckyResult {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    //构造器私有
    private LuckyResult(){

    }

    //通用返回成功
    public static LuckyResult ok(){
        LuckyResult result = new LuckyResult();
        result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    //通用返回失败，未知错误
    public static LuckyResult error(){
        LuckyResult result = new LuckyResult();
        result.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        result.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        result.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return result;
    }

    public static LuckyResult businessError(String msg){
        LuckyResult result = new LuckyResult();
        result.setSuccess(ResultCodeEnum.BUSINESS_ERROR.getSuccess());
        result.setCode(ResultCodeEnum.BUSINESS_ERROR.getCode());
        result.setMessage(msg);
        return result;
    }

    //链式编程，返回类本身
    //自定义返回数据
    public LuckyResult data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    //通用设置data
    public LuckyResult data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    //自定义返回结果
    public LuckyResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    //自定义状态码
    public LuckyResult code(Integer code){
        this.setCode(code);
        return this;
    }
    //自定义状态信息
    public LuckyResult message(String message){
        this.setMessage(message);
        return this;
    }
}
