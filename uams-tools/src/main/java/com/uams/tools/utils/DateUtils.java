package com.uams.tools.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * <p>File：DateUtils.java </p>
 * <p>Title: 日期工具类, 继承org.apache.commons.lang.time.DateUtils类 </p>
 * <p>Description: DateUtils </p>
 * <p>Copyright: Copyright (c) 2014 08/08/2015 15:18</p>
 * <p>Company: BloCain</p>
 *
 * @author playguy
 * @version 1.0
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils
{
    private static String[]     parsePatterns                   = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss",
            "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
    
    // RFC 822 Date Format
    private static final String RFC822_DATE_FORMAT              = "EEE, dd MMM yyyy HH:mm:ss z";
    
    // ISO 8601 format
    private static final String ISO8601_DATE_FORMAT             = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    
    // Alternate ISO 8601 format without fractional seconds
    private static final String ALTERNATIVE_ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    
    /**
     * Formats Date to GMT string.
     */
    public static String formatRfc822Date(Date date)
    {
        return getRfc822DateFormat().format(date);
    }
    
    /**
     * Parses a GMT-format string.
     */
    public static Date parseRfc822Date(String dateString) throws ParseException
    {
        return getRfc822DateFormat().parse(dateString);
    }
    
    private static DateFormat getRfc822DateFormat()
    {
        SimpleDateFormat rfc822DateFormat = new SimpleDateFormat(RFC822_DATE_FORMAT, Locale.US);
        rfc822DateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return rfc822DateFormat;
    }
    
    public static String formatIso8601Date(Date date)
    {
        return getIso8601DateFormat().format(date);
    }
    
    public static String formatAlternativeIso8601Date(Date date)
    {
        return getAlternativeIso8601DateFormat().format(date);
    }
    
    /**
     * Parse a date string in the format of ISO 8601.
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date parseIso8601Date(String dateString) throws ParseException
    {
        try
        {
            return getIso8601DateFormat().parse(dateString);
        }
        catch (ParseException e)
        {
            return getAlternativeIso8601DateFormat().parse(dateString);
        }
    }
    
    private static DateFormat getIso8601DateFormat()
    {
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT, Locale.US);
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df;
    }
    
    private static DateFormat getAlternativeIso8601DateFormat()
    {
        SimpleDateFormat df = new SimpleDateFormat(ALTERNATIVE_ISO8601_DATE_FORMAT, Locale.US);
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df;
    }
    
    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate()
    {
        return getDate("yyyy-MM-dd");
    }
    
    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern)
    {
        return DateFormatUtils.format(new Date(), pattern);
    }
    
    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object ... pattern)
    {
        String formatDate = null;
        if (pattern != null && pattern.length > 0)
        {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        }
        else
        {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }
    
    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date)
    {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime()
    {
        return formatDate(new Date(), "HH:mm:ss");
    }
    
    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime()
    {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear()
    {
        return formatDate(new Date(), "yyyy");
    }
    
    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth()
    {
        return formatDate(new Date(), "MM");
    }
    
    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay()
    {
        return formatDate(new Date(), "dd");
    }
    
    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek()
    {
        return formatDate(new Date(), "E");
    }
    
    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str)
    {
        if (str == null) { return null; }
        try
        {
            return parseDate(str.toString(), parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date)
    {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }
    
    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date)
    {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }
    
    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date)
    {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }
    
    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis)
    {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }
    
    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after)
    {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }
    
    /**
     * 日期、时间格式化
     * @param date Date 将要被格式化的日期对象
     * @param outFmt String 格式化输出的样式，参照SimpleDateFormat类说明，如：yyyy年MM月dd日
     * @return String 格式化后的日期、时间字符串，date为null时返回null，outFmt非法时返回yyyyMMdd格式
     */
    public static String getDateFormat(Date date, String outFmt)
    {
        if (date == null) return null;
        if (outFmt == null || "".equals(outFmt.trim())) outFmt = "yyyyMMdd";
        String retu = null;
        SimpleDateFormat dateFormat = null;
        try
        {
            dateFormat = new SimpleDateFormat(outFmt);
        }
        catch (IllegalArgumentException iaex)
        {
            dateFormat = new SimpleDateFormat("yyyyMMdd");
        }
        retu = dateFormat.format(date);
        dateFormat = null;
        return retu;
    }
    
    /**
     * 日期、时间格式化
     * @param millis long the number of milliseconds（毫秒） since January 1, 1970, 00:00:00 GMT.
     * @param outFmt String 返回样式，参照类说明，如：yyyy年MM月dd日
     * @return String 格式化后的日期、时间字符串
     */
    public static String getDateFormat(long millis, String outFmt)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        String retu = getDateFormat(calendar.getTime(), outFmt);
        calendar = null;
        return retu;
    }
    
    /**
     * 获取上周一0点0分时间戳
     * @return
     * @throws ParseException
     */
    public static long getPrevWeekMonday()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取指定时间当周上周一0点0分时间戳
     * @return
     * @throws ParseException
     */
    public static long getPrevWeekMonday(long times)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(times);
        cal.add(Calendar.DATE, -7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取指定时间上个月第一天一0点0分时间戳
     * @return
     * @throws ParseException
     */
    public static long getPrevMonFirstDay(long times)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(times);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取指定时间上个月最后一天一0点0分时间戳
     * @return
     * @throws ParseException
     */
    public static long getPrevMonLastDay(long times)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(times);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取指定时间上个月最后一天最后一秒的时间
     * @return
     * @throws ParseException
     */
    public static long getPrevMonLastDayTime(long times)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(times);
        cal.add(Calendar.MONTH, -1);
        cal.add(Calendar.HOUR_OF_DAY, 23);
        cal.add(Calendar.MINUTE, 59);
        cal.add(Calendar.SECOND, 59);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取指定时间当月月第一天一0点0分时间戳
     * @return
     * @throws ParseException
     */
    public static long getCurrenMonFirstDay(long times)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(times);
        // cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        System.out.println(monday);
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取这周一0点0分的时间戳
     * @return
     */
    public static long getThisWeekMonday()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取指定时间当周的周一0点0分的时间戳
     * @return
     */
    public static long getThisWeekMonday(long times)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(times);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取指定时间当周上周日0点0分时间戳
     * @return
     */
    public static long getPrevWeekSunday(long times)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(times);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    /**
     * 获取上周日0点0分时间戳
     * @return
     */
    public static long getPrevWeekSunday()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String monday = df.format(cal.getTime());
        try
        {
            Date date = df.parse(monday);
            return date.getTime();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }
    
    public static void main(String args[])
    {
        /*
         * long prevWeekMonday = DateUtils.getPrevWeekMonday(1472659200000l);
         * long thisWeekMonday = DateUtils.getThisWeekMonday(1472659200000l);
         * long prevWeekSunday = DateUtils.getPrevWeekSunday(1472659200000l);
         * System.out.println(prevWeekMonday);
         * System.out.println(thisWeekMonday);
         * System.out.println(prevWeekSunday);
         */
        // Date d = DateUtils.parseDate("2016-09-03");
        long prevMonMonday = DateUtils.getPrevMonFirstDay(1488643200000l);
        long thisWeekMonday = DateUtils.getCurrenMonFirstDay(1488643200000l);
        System.out.println(prevMonMonday);
        System.out.println(thisWeekMonday);
    }
}
