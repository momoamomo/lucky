package exception;

/**
 * @author sunzhilin
 * @date 2020/8/12  11:51
 */
public interface IErrorEnum<T, T1> {
    T getErrCode();
    T1 getErrMsg();
}
