package com.taeyeon.zyx.utils;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/1 下午9:46
 * @Description: Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    //日期
    public static final String YEAR_TO_DAY = "yyyy-MM-dd";
    //24小时制，精确到秒
    public static final String YEAR_TO_SEC = "yyyy-MM-dd HH:mm:ss";
    //24小时制，精确到分
    public static final String YEAR_TO_MINUTE = "yyyy-MM-dd HH:mm";

    public static final String MONTH_TO_MINUTE = "MM-dd HH:mm";

    public static final String HOUR_TO_SEC = "HH:mm:ss";
    public static final String HOUR_TO_MIN = "HH:mm";

    public static final String YEAR_TO_MS_UN_LINE = "yyyyMMdd HHmmssSSS";

    public static final String YEAR_TO_SEC_UN_LINE = "yyyyMMdd HHmmss";

    public static final String YEAR_TO_MI_UN_LINE = "yyyyMMdd HHmm";

    public static final String YEAR_TO_DAY_UN_LINE = "yyyyMMdd";

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date now() {
        return new Date();
    }

    public static Date getDate(Long time) {
        return new Date(time);
    }

    public static Date parseDateTimeSec(String str) throws ParseException {
        return parseDate(str, YEAR_TO_SEC);
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(now(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        }
        else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        String formatStr = null;
        try {
            formatStr = formatDate(date, "yyyy-MM-dd HH:mm:ss");
            return formatStr;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 将HH:mm:ss 格式转换为秒
     */
    public static int parseDurationTosecond(String duration) {
        if (StringUtils.isBlank(duration)) {
            return 0;
        }
        String[] time = duration.split(":");
        if (time.length != 3) {
            return 0;
        }
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int sec = Integer.parseInt(time[2]);
        int totalSec = hour * 3600 + min * 60 + sec;
        return totalSec;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateDay(Date date) {
        String formatStr = null;
        try {
            formatStr = formatDate(date, "yyyy-MM-dd");
            return formatStr;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 得到unix时间戳对应时间格式字符串
     * @param unixTime
     * @param pattern
     * @return
     */
    public static String formatUnixTime(Long unixTime, String pattern) {
        if (unixTime == null || unixTime <= 0) {
            return "";
        }
        return formatDate(new Date(unixTime * 1000), pattern);
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(now(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(now(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(now(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(now(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(now(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(now(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }


    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, hour);
        return c.getTime();
    }

    /**
     * <p>Title: addMin</p>
     * <p>Description: 加分钟</p>
     * @param date 时间
     * @param min 分钟数
     * @return Date
     *
     */
    public static Date addMin(Date date, int min) {
        Date result = null;

        if (date != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.MINUTE, min);
            result = c.getTime();
        }

        return result;
    }

    /**
     * 获取过去的天数
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = now().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = now().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = now().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    public static String getDistanceOf2UnixTime(Long time1, Long time2) {
        if (time1 == null || time2 == null) {
            return "";
        }
        long num = Math.abs(time2 - time1) * 1000;
        return formatDateTime(num);
    }

    public static String formatUnixDateTime(Long time) {
        if (time == null) {
            return "";
        }
        return formatDateTime(time * 1000);
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 判断是否过期
     *
     * @param date
     * @return true 过期; false 不过期
     */
    public static Boolean isExpired(Date date) {
        if (null == date) {
            return false;
        }
        long dateMillis = date.getTime();
        long now = (now()).getTime();

        return (now > dateMillis ? true : false);
    }

    /**
     * 获取指定日期所在分钟的第0秒（秒取00：2018-05-31 14:45:00）
     * @param now
     * @return
     */
    public static Date getFirstSecondOfMinute(Date now) {
        Calendar cal_1 = Calendar.getInstance();
        cal_1.setTime(now);
        cal_1.set(Calendar.SECOND, 0);
        return cal_1.getTime();
    }

    public static Date getFirstDateOfMonth(Date now) {
        Calendar cal_1 = Calendar.getInstance();
        cal_1.setTime(now);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        return cal_1.getTime();
    }

    public static Date getLastDateOfMonth(Date now) {
        Calendar cal_1 = Calendar.getInstance();
        cal_1.setTime(now);
        cal_1.set(Calendar.DAY_OF_MONTH, cal_1.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal_1.getTime();
    }

    /**
     * 取得指定日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 取得指定日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 得到当期时间的周系数
     *
     * @param date
     * @return
     */
    public static Integer dayForWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取某一时间段特定星期几的日期
     *
     * @param dateFrom 开始时间
     * @param dateEnd  结束时间
     * @param weekDays 星期
     * @return 返回时间数组
     */
    public static List<Date> getDates(String dateFrom, String dateEnd, List<Integer> weekDays) {
        List<Date> dateList = new ArrayList<>();
        Date dateFromTime = DateUtils.parseDate(dateFrom);
        dateFromTime = DateUtils.addDays(dateFromTime, -1);
        while (true) {
            dateFromTime = DateUtils.addDays(dateFromTime, 1);
            if (dateFromTime.compareTo(DateUtils.parseDate(dateEnd)) <= 0) {
                Integer weekDay = dayForWeek(dateFromTime);
                if (weekDays.contains(weekDay)) {
                    dateList.add(dateFromTime);
                }
            }
            else {
                break;
            }
        }
        return dateList;
    }

    /**
     * 检查时间是否有交叉
     *
     * @param timeRange
     * @param timeRange2
     * @return
     */
    public static boolean checkTimeCross(TimeRange timeRange, TimeRange timeRange2) {
        return timeRange2.getStartTime().compareTo(timeRange.getEndTime()) < 0
                && timeRange2.getEndTime().compareTo(timeRange.getStartTime()) > 0;
    }

    /**
     * 是否是时分HH:mm时间格式
     *
     * @param time
     * @return
     */
    public static boolean isShortTimePattern(String time) {
        return Pattern.matches("^([01]\\d|2[01234]):([0-5]\\d)$", time);
    }

    /**
     * 获取天，截取时分秒
     *
     * @param date
     * @return
     */
    public static Date getDay(Date date) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        // 将时分秒,毫秒域清零
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

    /**
     * 在时间范围之内
     *
     * @param sourceTime 时间范围 HH:mm-HH:mm
     * @param curTime 时间 格式 HH:mm
     * @return
     */
    public static boolean withinShortTime(String sourceTime, String curTime) {
        if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
        if (curTime == null || !curTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
        }
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat(HOUR_TO_MIN);
        try {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            if (args[1].equals("00:00")) {
                args[1] = "24:00";
            }
            if (end < start) {
                return now < end || now > start;
            }
            else {
                return now >= start && now <= end;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = now().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));

        System.out.println(getDistanceOf2UnixTime(800000L, 40000L));
    }
}

