package com.taeyeon.zyx.utils;

/**
 * @author zyx
 * @date 2018/9/27 027 10:47
 */

import com.taeyeon.zyx.exception.InvalidDateTimeFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateTime {
    private static final Logger logger = LoggerFactory.getLogger(DateTime.class);
    private static final SimpleDateFormat GET_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static long timestamp = 0L;
    private static final String IS_DATE_REGEX = "^[0-9]{4}\\-[0-9]{1,2}\\-[0-9]{1,2}$";
    private static final String IS_TIME_REGEX = "^[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$";
    private static final String IS_DATETIME_REGEX = "^[0-9]{4}\\-[0-9]{1,2}\\-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}(\\.[0-9]{1,3})?$";
    private static final String[] CN_WEEK_NAMES = new String[]{"天", "一", "二", "三", "四", "五", "六"};
    private static final String[] EN_WEEK_NAMES = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final SimpleDateFormat GET_INT_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    private DateTime() {
    }

    public static int getDayCount() {
        long daynum = System.currentTimeMillis() / 1000L / 60L / 60L / 24L;
        return (int)daynum;
    }

    public static int getDayCount(String datetime) {
        int[] arr = parseDatetimeToArray(datetime);
        int year = arr[0];
        int month = arr[1];
        int day = arr[2];
        Calendar cal = getCalendar();
        cal.set(year, month - 1, day);
        long daynum = cal.getTimeInMillis() / 1000L / 60L / 60L / 24L;
        return (int)daynum;
    }

    public static int getDayCount(String date1, String date2) {
        int dayCount1 = getDayCount(date1);
        int dayCount2 = getDayCount(date2);
        return Math.abs(dayCount1 - dayCount2);
    }

    public static String getDate() {
        long time = getTimestamp();
        return getDate(time);
    }

    public static String getDate(int daynum) {
        Calendar cal = getCalendar();
        cal.add(5, daynum);
        return getDate(cal.getTimeInMillis());
    }

    public static String addDate(int daynum) {
        Calendar cal = getCalendar();
        cal.add(5, daynum);
        return getDate(cal.getTimeInMillis());
    }

    public static String addDate(String date, int daynum) {
        int[] arr = parseDatetimeToArray(date);
        int year = arr[0];
        int month = arr[1];
        int day = arr[2];
        Calendar cal = getCalendar();
        cal.set(year, month - 1, day + daynum);
        return getDate(cal.getTimeInMillis());
    }

    public static Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        if (timestamp == 0L) {
            return cal;
        } else {
            long time = getTimestamp();
            Date date = new Date(time);
            cal.setTime(date);
            return cal;
        }
    }

    public static String addDateReturnTime(String date, int daynum) {
        int[] arr = parseDatetimeToArray(date);
        int year = arr[0];
        int month = arr[1];
        int day = arr[2];
        Calendar cal = getCalendar();
        cal.set(year, month - 1, day + daynum);
        return getTime(cal.getTimeInMillis());
    }

    public static int[] parseDatetimeToArray(String datetime) {
        int year = Integer.parseInt(datetime.substring(0, 4));
        int month = Integer.parseInt(datetime.substring(5, 7));
        int day = Integer.parseInt(datetime.substring(8, 10));
        return new int[]{year, month, day};
    }

    public static synchronized String getDate(long millis) {
        Date date = new Date();
        if (millis > 0L) {
            date.setTime(millis);
        }

        return GET_DATE_FORMAT.format(date);
    }

    public static int getHour() {
        Calendar cld = getCalendar();
        return cld.get(11);
    }

    public static int getDay() {
        Calendar cld = getCalendar();
        return cld.get(5);
    }

    public static int getMonth() {
        Calendar cld = getCalendar();
        return cld.get(2);
    }

    public static int getMinute() {
        Calendar cld = getCalendar();
        return cld.get(12);
    }

    public static int getMinuteCount(String time) {
        long timestamp = getTimestamp(time);
        int minute = (int)(timestamp / 1000L / 60L);
        minute += 480;
        return minute;
    }

    public static int getCurrentDayMinuteCount(String time) {
        int minute = getMinuteCount(time);
        minute %= 1440;
        return minute;
    }

    public static String getTime() {
        long time = getTimestamp();
        return getTime(time);
    }

    public static String getRegisterCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date());
    }

    public static String addTime(int minute) {
        long millis = System.currentTimeMillis();
        millis += (long)minute * 60L * 1000L;
        return getTime(millis);
    }

    public static String addTime(String time, int minute) {
        long millis = getTimestamp(time);
        millis += (long)minute * 60L * 1000L;
        return getTime(millis);
    }

    public static String getTime(int second) {
        long millis = (long)second * 1000L;
        return getTime(millis);
    }

    public static String getTime(long millis) {
        Date date = new Date();
        if (millis > 0L) {
            date.setTime(millis);
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(new Date());
    }

    public static String getCurrentTimeToMinute() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        return format.format(new Date());
    }

    public static String formatDatabaseTime(String datetime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return format.format(format.parse(datetime));
        } catch (ParseException var3) {
            logger.error(var3.getMessage(), var3);
            return null;
        }
    }

    public static int getSecond(String datetime) {
        long time = getTimestamp(datetime);
        return (int)(time / 1000L);
    }

    public static long getTimestamp(String datetime) {
        Calendar cal = getCalendar();
        int year = Integer.parseInt(datetime.substring(0, 4));
        int month = Integer.parseInt(datetime.substring(5, 7));
        int day = Integer.parseInt(datetime.substring(8, 10));
        int hour = Integer.parseInt(datetime.substring(11, 13));
        int minute = Integer.parseInt(datetime.substring(14, 16));
        int second = Integer.parseInt(datetime.substring(17, 19));
        cal.set(year, month - 1, day, hour, minute, second);
        if (datetime.length() > 19) {
            logger.info("datetime:" + datetime);
            int mill = Integer.parseInt(datetime.substring(20));
            cal.set(14, mill);
        } else {
            cal.set(14, 0);
        }

        return cal.getTimeInMillis();
    }

    public static void setTimestamp(String date) {
        long millis = System.currentTimeMillis();
        String datetime;
        if (date.length() > 10) {
            datetime = date;
        } else {
            String time = getTime(millis);
            datetime = date + time.substring(10);
        }

        long timestamp = getTimestamp(datetime);
        setTimestamp(timestamp - millis);
        logger.info("timestamp:" + timestamp);
    }

    public static void setTimestamp(long timestamp) {
        timestamp = timestamp;
    }

    public static long currentTimeMillis() {
        return getTimestamp();
    }

    public static long getTimestamp() {
        long time;
        if (timestamp != 0L) {
            time = System.currentTimeMillis() + timestamp;
            return time;
        } else {
            time = System.currentTimeMillis();
            return time;
        }
    }

    public static int getUnixTimestamp() {
        long timestamp = getTimestamp();
        return (int)(timestamp / 1000L);
    }

    public static int getUnixTimestamp(String datetime) {
        long timestamp = getTimestamp(datetime);
        return (int)(timestamp / 1000L);
    }

    public static boolean isDate(String date) {
        return date == null ? false : date.matches("^[0-9]{4}\\-[0-9]{1,2}\\-[0-9]{1,2}$");
    }

    public static boolean isTime(String time) {
        return time == null ? false : time.matches("^[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$");
    }

    public static boolean isDateTime(String str) {
        return str.matches("^[0-9]{4}\\-[0-9]{1,2}\\-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}(\\.[0-9]{1,3})?$");
    }

    public static String getGMT(String time) {
        Calendar cal = getCalendar();
        cal.setTimeInMillis(getTimestamp(time));
        Date date = cal.getTime();
        return date.toGMTString();
    }

    public static String getWeekName() {
        Calendar cal = getCalendar();
        int day = cal.get(7) - 1;
        return CN_WEEK_NAMES[day];
    }

    public static String getWeekName(String datetime) {
        Calendar cld = getCalendar();
        cld.setTimeInMillis(getTimestamp(datetime));
        int num = cld.get(7) - 1;
        return EN_WEEK_NAMES[num];
    }

    public static int getDayCountOfMonth(int monthNum) {
        Calendar cal = getCalendar();
        cal.add(2, monthNum);
        cal.set(5, 1);
        int daynum = cal.getActualMaximum(5);
        return daynum;
    }

    public static String getFirstDayOfMonth(int monthNum) {
        Calendar cal = getCalendar();
        cal.add(2, monthNum);
        cal.set(5, 1);
        return getDate(cal.getTimeInMillis());
    }

    public static String getFirstDayOfMonth(String date, int monthNum) {
        int[] arr = parseDatetimeToArray(date);
        int year = arr[0];
        int month = arr[1];
        int day = arr[2];
        Calendar cal = getCalendar();
        cal.set(year, month - 1, day);
        cal.add(2, monthNum);
        cal.set(5, 1);
        return getDate(cal.getTimeInMillis());
    }

    public static void test() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss G E D F w W a E F");
        System.out.println(format.format(date));
    }

    public static String getMonday(String date) {
        int[] arr = parseDatetimeToArray(date);
        int year = arr[0];
        int month = arr[1];
        int day = arr[2];
        Calendar cal = getCalendar();
        cal.set(year, month - 1, day);
        cal.setFirstDayOfWeek(2);
        cal.set(7, 2);
        return getDate(cal.getTimeInMillis());
    }

    public static boolean isToday(String time) {
        if (time != null && time.length() >= 10) {
            time = time.substring(0, 10);
            return getDate().equals(time);
        } else {
            return false;
        }
    }

    public static synchronized String getIntTime() {
        Date date = new Date();
        return GET_INT_TIME_FORMAT.format(date);
    }

    public static int getTimeDayCount(String dateTime) {
        String currentTime = getTime();
        return getTimeDayCount(currentTime, dateTime);
    }

    public static int getTimeDayCount(String beginTime, String endTime) {
        Date beginDateTime = getTime(beginTime);
        Date endDateTime = getTime(endTime);
        int day = 86400000;
        long begin = beginDateTime.getTime();
        long end = endDateTime.getTime();
        return (int)((end - begin) / (long)day);
    }

    public static Date getTime(String datetime) {
        String dateFmt = "yyyy-MM-dd HH:mm:ss";
        return toDate(datetime, dateFmt);
    }

    public static Date toDate(String datetime, String dateFmt) {
        SimpleDateFormat format = new SimpleDateFormat(dateFmt);

        try {
            Date date = format.parse(datetime);
            return date;
        } catch (ParseException var5) {
            throw new InvalidDateTimeFormatException(datetime);
        }
    }
}

