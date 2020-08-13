package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

/**
 * 时间工具类，基于java 8 time包
 *
 * @author wgy
 * @date 2018/6/6
 */
public class DateTimeUtil {

    private static final ConcurrentMap<String, DateTimeFormatter> FORMATTER_CACHE = new ConcurrentHashMap<>();

    private static final int PATTERN_CACHE_SIZE = 500;

    /**
     * Date转换为格式化时间
     *
     * @param date    date
     * @param pattern 格式
     * @return
     */
    public static String format(Date date, String pattern) {
        return format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()), pattern);
    }

    /**
     * localDateTime转换为格式化时间
     *
     * @param localDateTime localDateTime
     * @param pattern       格式
     * @return
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = createCacheFormatter(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * localDateTime转换为格式化时间
     *
     * @param localDate localDate
     * @param pattern   格式
     * @return
     */
    public static String format(LocalDate localDate, String pattern) {
        DateTimeFormatter formatter = createCacheFormatter(pattern);
        return localDate.format(formatter);
    }

    /**
     * 格式化字符串转为Date
     *
     * @param time    格式化时间
     * @param pattern 格式
     * @return
     */
    public static Date parseDate(String time, String pattern) {
        return Date.from(parseLocalDateTime(time, pattern).atZone(ZoneId.systemDefault()).toInstant());

    }

    /**
     * 格式化字符串转为LocalDateTime
     *
     * @param time    格式化时间
     * @param pattern 格式
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String time, String pattern) {
        DateTimeFormatter formatter = createCacheFormatter(pattern);
        return LocalDateTime.parse(time, formatter);
    }

    /**
     * 格式化字符串转为LocalDate
     *
     * @param date    格式化时间
     * @param pattern 格式
     * @return
     */
    public static LocalDate parseLocalDate(String date, String pattern) {
        DateTimeFormatter formatter = createCacheFormatter(pattern);
        return LocalDate.parse(date, formatter);
    }

    /**
     * Date转换为LocalDateTime
     *
     * @param date java.util.Date
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Date转换为LocalDate
     *
     * @param date java.util.Date
     * @return java.time.LocalDate
     */
    public static LocalDate toLocalDate(Date date) {
        return toLocalDateTime(date).toLocalDate();
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime java.time.LocalDateTime
     * @return java.util.Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate转换为Date，取的是当天开始时间
     *
     * @param localDate java.time.LocalDate
     * @return java.util.Date
     */
    public static Date toDate(LocalDate localDate) {
        return toDate(localDate.atStartOfDay());
    }

    /**
     * 转换时间pattern
     *
     * @param time   时间
     * @param source 源格式
     * @param dest   目的格式
     * @return
     */
    public static String convertPattern(String time, String source, String dest) {
        return format(parseDate(time, source), dest);
    }

    /**
     * 在缓存中创建DateTimeFormatter
     *
     * @param pattern 格式
     * @return DateTimeFormatter
     */
    private static DateTimeFormatter createCacheFormatter(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        DateTimeFormatter formatter = FORMATTER_CACHE.get(pattern);
        if (formatter == null) {
            if (FORMATTER_CACHE.size() < PATTERN_CACHE_SIZE) {
                formatter = DateTimeFormatter.ofPattern(pattern);
                DateTimeFormatter oldFormatter = FORMATTER_CACHE.putIfAbsent(pattern, formatter);
                if (oldFormatter != null) {
                    formatter = oldFormatter;
                }
            }
        }
        return formatter;
    }

    /**
     * 判断时间是否在本月
     *
     * @param sourceDate
     * @return
     */
    public static Boolean isInMonth(LocalDateTime sourceDate) {
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime beginDate = nowDate.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).toLocalDate().atTime(LocalTime.MAX);
        LocalDateTime endDate = nowDate.plusMonths(1).with(TemporalAdjusters.firstDayOfMonth()).toLocalDate().atTime(LocalTime.MIN);
        return sourceDate.isAfter(beginDate) && sourceDate.isBefore(endDate);
    }

    /**
     * 求两个日期的相差天数的List
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<LocalDate> getPeriodDays(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> list = new ArrayList<>();
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        Stream.iterate(startDate, d -> {
            return d.plusDays(1);
        }).limit(distance + 1).forEach(f -> {
            list.add(f);
        });
        return list;
    }

    /**
     * 求两个时间相差小时的List
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<LocalDateTime> getPeriodHours(LocalDateTime startTime, LocalDateTime endTime) {
        List<LocalDateTime> list = new ArrayList<>();
        long hours = startTime.until(endTime, ChronoUnit.HOURS);
        Stream.iterate(startTime, d -> {
            return d.plusHours(1);
        }).limit(hours + 1).forEach(f -> {
            list.add(f);
        });
        return list;
    }
}
