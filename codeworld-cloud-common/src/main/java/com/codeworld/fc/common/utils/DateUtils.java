package com.codeworld.fc.common.utils;



import org.hibernate.annotations.common.util.StringHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Lenovo
 */
public class DateUtils {

    /**
     * 日期格式yyyy-MM-dd
     */
    public static final String pattern_date = "yyyy-MM-dd";

    /**
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     */
    public static final String pattern_time = "yyyy-MM-dd HH:mm:ss";

    /**
     * 描述：日期格式化
     *
     * @param date 日期
     * @return 输出格式为 yyyy-MM-dd 的字串
     */
    public static String formatDate(Date date) {

        return formatDate(date, pattern_time);

    }

    /**
     * 描述：日期格式化
     *
     * @param date    日期
     * @param pattern 格式化类型
     * @return
     */
    public static String formatDate(Date date, String pattern) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(date);
    }

    /**
     * 描述：解析日期字串
     *
     * @param dateStr 日期字串
     * @return 按 yyyy-MM-dd HH:mm:ss 格式解析
     */
    public static Date parseString(String dateStr) {

        return parseString(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 描述：解析日期字串
     *
     * @param dateStr 日期字串
     * @param pattern 字串日期格式
     * @return 对应日期类型数据
     */
    public static Date parseString(String dateStr, String pattern) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {

            if (!StringHelper.isEmpty(dateStr)) {

                return dateFormat.parse(dateStr);

            }
        } catch (ParseException ex) {

            ex.printStackTrace();

            System.err.println(dateStr + "转换成日期失败，可能是不符合格式：" + pattern);
        }
        return null;
    }

    /**
     * 描述：获取指定日期的中文星期数
     *
     * @param date 指定日期
     * @return 星期数，如：星期一
     */
    public static String getWeekStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(7);
        --week;
        String weekStr = "";
        switch (week) {
            case 0:
                weekStr = "星期日";
                break;
            case 1:
                weekStr = "星期一";
                break;
            case 2:
                weekStr = "星期二";
                break;
            case 3:
                weekStr = "星期三";
                break;
            case 4:
                weekStr = "星期四";
                break;
            case 5:
                weekStr = "星期五";
                break;
            case 6:
                weekStr = "星期六";
        }
        return weekStr;
    }

    /**
     * 描述：间隔时间
     *
     * @param date1
     * @param date2
     * @return 毫秒数
     */
    public static long getDateMiliDispersion(Date date1, Date date2) {
        if ((date1 == null) || (date2 == null)) {
            return 0L;
        }

        long time1 = date1.getTime();
        long time2 = date2.getTime();

        return time1 - time2;
    }

    /**
     * 描述：间隔天数
     *
     * @param date1
     * @param date2
     * @return 天数
     */
    public static int getDateDiff(Date date1, Date date2) {
        if ((date1 == null) || (date2 == null)) {
            return 0;
        }
        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long diff = time1 - time2;

        Long longValue = new Long(diff / 86400000L);
        return longValue.intValue();
    }

    /**
     * 描述：获取指定日期之前多少天的日期
     *
     * @param date 指定日期
     * @param day  天数
     * @return 日期
     */
    public static Date getDataDiff(Date date, int day) {
        if (date == null) {
            return null;
        }
        long time = date.getTime();
        time -= 86400000L * day;
        return new Date(time);
    }

    /**
     * 描述：获取当前周
     *
     * @return
     */
    public static int getCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(7);
        --week;
        if (week == 0) {
            week = 7;
        }
        return week;
    }

    /**
     * 描述：获取中文当前周
     *
     * @return
     */
    public static String getCurrentWeekStr() {
        return getWeekStr(new Date());
    }

    /**
     * 描述：获取本年
     *
     * @return
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1);
    }

    /**
     * 描述：获取本月
     *
     * @return
     */
    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(2) + 1;
    }

    /**
     * 描述：获取本月的当前日期数
     *
     * @return
     */
    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5);
    }

    /**
     * 描述：当前时间与指定时间的差
     *
     * @param str 秒数
     * @return 时间差，单位：秒
     */
    public static int getUnixTime(String str) {
        if ((str == null) || ("".equals(str))) {
            return 0;
        }
        try {
            long utime = Long.parseLong(str) * 1000L;
            Date date1 = new Date(utime);

            Date date = new Date();

            long nowtime = (date.getTime() - date1.getTime()) / 1000L;
            return (int) nowtime;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("获取时差失败");
        }
        return 0;
    }

    /**
     * 描述：去除日期字串中原“-”和“:”
     *
     * @param dateTime
     * @return
     */
    public static String formatString(String dateTime) {
        if ((dateTime != null) && (dateTime.length() >= 8)) {
            String formatDateTime = dateTime.replaceAll("-", "");
            formatDateTime = formatDateTime.replaceAll(":", "");
            String date = formatDateTime.substring(0, 8);
            return date;
        }

        return "";
    }

    /**
     * 描述：当前时间与指定时间的差
     *
     * @param str yyyy-MM-dd HH:mm:ss 格式的日期
     * @return 时间差，单位：秒
     */
    public static int getTimesper(String str) {
        if ((str == null) || ("".equals(str))) {
            return 0;
        }
        try {
            Date date1 = new Date(Long.parseLong(str));
            Date date = new Date();
            long nowtime = (date.getTime() - date1.getTime()) / 1000L;
            return (int) nowtime;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("日期转换出错");
        }
        return 0;
    }

    /**
     * 描述：获取16位日期时间，yyyyMMddHHmmss
     *
     * @param dateTime 字串日期
     * @return
     */
    public static String formatDateTime(String dateTime) {
        if ((dateTime != null) && (dateTime.length() >= 8)) {
            String formatDateTime = dateTime.replaceAll("-", "");
            formatDateTime = formatDateTime.replaceAll(":", "");
            String date = formatDateTime.substring(0, 8);
            String time = formatDateTime.substring(8).trim();
            for (int i = time.length(); i < 6; ++i) {
                time = time + "0";
            }
            return date + time;
        }

        return "";
    }

    /**
     * 描述：获取16位日期时间，yyyyMMddHHmmss
     *
     * @param date 日期
     * @return
     */
    public static String formatDateTime(Date date) {

        String dateTime = formatDate(date);

        return formatDateTime(dateTime);
    }

    public static String formatInstant(Instant instant, String format) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    /***
     * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDate(date, dateFormat);
    }
}
