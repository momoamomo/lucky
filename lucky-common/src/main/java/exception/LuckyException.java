package exception;

/**
 * 自定义异常
 *
 * @author sunzhilin
 * @date 2020/8/12  11:38
 */
public class LuckyException extends RuntimeException {

    private String code;

    public LuckyException(String code, String message) {
        super(message);
        this.code = code;
    }

    public LuckyException(IErrorEnum<String, String> errorEnum) {
        super(errorEnum.getErrMsg());
        this.code = errorEnum.getErrCode();
    }
}
