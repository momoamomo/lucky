package util;

import enums.CommonErrorEnum;
import exception.LuckyException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.ConcurrentReferenceHashMap;
import org.springframework.util.StringUtils;

import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 基础校验工具
 *
 * @author sunzhilin
 * @date 2020/8/12  11:26
 */
@Slf4j
public class BaseChecker {
    private static final Map<String, Pattern> PATTERN_CACHE = new ConcurrentReferenceHashMap<>(256);

    /**
     * 检查对象是否为空
     *
     * @param toCheck 待检查对象
     * @param name 对象名称
     */
    public static void checkNotNull(Object toCheck, String name){
        if(StringUtils.isEmpty(toCheck)){
            log.error("{}参数为空",name);
            throw new LuckyException(CommonErrorEnum.LACK_PARAMS);
        }
    }

    /**
     * 检查字符串是否超长
     *
     * @param toCheck 待检查字符串
     * @param name    字符串名称
     * @param length  待检长度
     */
    public static void checkLength(String toCheck, String name, int length){
        if(toCheck ==null){
            return;
        }
        if(toCheck.length()>length){
            log.error("{}参数超过长度{}",name,length);
            throw new LuckyException(CommonErrorEnum.PARAMS_FORMAT_ERROR);
        }
    }

    /**
     * 检查大小是否超过限定
     *
     * @param size      待检查大小
     * @param name      大小名称
     * @param limitSize 待检大小
     */
    public static void checkSize(Integer size, String name, Integer limitSize) {
        if (size == null) {
            return;
        }
        if (size > limitSize) {
            log.error("{}参数大小超过{}", name, limitSize);
            throw new LuckyException(CommonErrorEnum.PARAMS_FORMAT_ERROR);
        }
    }

    /**
     * 检查大小是否超过限定
     *
     * @param size      待检查大小
     * @param name      大小名称
     * @param limitSize 待检大小
     */
    public static void checkSizeMinimum(Integer size, String name, Integer limitSize) {
        if (size == null) {
            return;
        }
        if (size < limitSize) {
            log.error("{}参数大小小于{}", name, limitSize);
            throw new LuckyException(CommonErrorEnum.PARAMS_FORMAT_ERROR);
        }
    }

    /**
     * 检查字符串是否符合正则表达式
     *
     * @param toCheck 待检查字符串
     * @param pattern 正则表达式
     * @param name    字符串名称
     */
    public static void checkPattern(String toCheck, String name, String pattern) {
        Pattern value = PATTERN_CACHE.get(pattern);
        if (value == null) {
            value = Pattern.compile(pattern);
            PATTERN_CACHE.put(pattern, value);
        }
        if (!value.matcher(toCheck).matches()) {
            log.error("{}参数格式错误", name);
            throw new LuckyException(CommonErrorEnum.PARAMS_FORMAT_ERROR);
        }
    }

    /**
     * 检查字符串是否符合时间格式
     *
     * @param toCheck 待检查字符串
     * @param name    字符串名称
     * @param pattern 时间格式
     */
    public static void checkTime(String toCheck, String name, String pattern) {
        try {
            DateTimeUtil.parseDate(toCheck, pattern);
        } catch (DateTimeParseException e) {
            log.error("{}时间格式错误", name);
            throw new LuckyException(CommonErrorEnum.PARAMS_FORMAT_ERROR);
        }
    }

}
