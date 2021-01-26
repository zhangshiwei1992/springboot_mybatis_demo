package com.zsw.demo;

import com.alibaba.druid.util.StringUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: 日期工具类
 * @Author: wubing
 */
public class DateUtil {
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyy_MM_dd_Space_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String yyyy_MM_dd_Space_E_Space_HH_mm = "yyyy-MM-dd E HH:mm";
    public static final String YYYYMMDD_HHMMSS = "yyyyMMdd HHmmss";
    public static final String ONLYDATE_WITH_FORMATTER = "yyyy-MM";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMdd_Space_HHmmss = "yyyyMMdd HHmmss";
    public static final String yyyyMonthDay = "MM月dd日";
    public static final String YYYYMM = "yyyyMM";

    /**
     * 将月 日 不满2位的， 填充0
     *
     * @param date yyyy-M-d, yyyy-M-dd, yyyy-MM-d
     * @return yyyy-MM-dd
     */
    public static String formatDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return "";
        }
        String spilter = "-";
        String[] tmpArr = date.split(spilter);
        if (tmpArr == null || tmpArr.length < 3) {
            return "";
        }
        if (tmpArr[1].length() == 1) {
            tmpArr[1] = "0" + tmpArr[1];
        }
        if (tmpArr[2].length() == 1) {
            tmpArr[2] = "0" + tmpArr[2];
        }
        return tmpArr[0] + spilter + tmpArr[1] + spilter + tmpArr[2];
    }

    /**
     * 获取当前时间的格式化后字符串
     *
     * @param pattern
     * @return
     */
    public static String formatCalendar(String pattern) {
        Calendar calendar = Calendar.getInstance();
        return formatCalendar(calendar, pattern);
    }

    /**
     * 获取传入时间的格式化后字符串
     *
     * @param calendar
     * @param pattern
     * @return
     */
    public static String formatCalendar(Calendar calendar, String pattern) {
        return formatCalendar(calendar, pattern, TimeZone.getTimeZone("GMT+8"));
    }

    /**
     * 获取传入时间和时区的格式化后字符串
     *
     * @param calendar
     * @param pattern
     * @param timeZone
     * @return
     */
    public static String formatCalendar(Calendar calendar, String pattern, TimeZone timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        formatter.setTimeZone(timeZone);
        return formatter.format(calendar.getTime());
    }

    /**
     * 字符串转化为 Calendar
     *
     * @param strDate
     * @param formatter
     * @return
     * @throws ParseException
     */
    public static Calendar fromStringToCalendar(String strDate, String formatter) throws ParseException {
        Date date = fromStringToDate(strDate, formatter);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static XMLGregorianCalendar fromDateToXMLGregorianCalendar(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        XMLGregorianCalendar xgcal = null;
        try {
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return xgcal;
    }

    public static XMLGregorianCalendar addXMLGregorianCalendarDays(XMLGregorianCalendar calendar, int days) {
        Date d = fromXMLGregorianCalendarToDate(calendar);
        d = new Date(d.getTime() + days * 24 * 60 * 60 * 1000L);
        return fromDateToXMLGregorianCalendar(d);
    }

    public static XMLGregorianCalendar getNowXMLGregorianCalendar() {
        XMLGregorianCalendar d = fromDateToXMLGregorianCalendar(new Date());
        return d;
    }

    public static Calendar getNowCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        return calendar;
    }

    public static Date fromXMLGregorianCalendarToDate(XMLGregorianCalendar calendar) {
        return calendar.toGregorianCalendar().getTime();
    }

    public static XMLGregorianCalendar fromStringToGregorianCalendar(String strDate, String formatter) {

        XMLGregorianCalendar xgcal = null;
        try {
            Date date = fromStringToDate(strDate, formatter);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);

            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return xgcal;
    }

    public static Date fromStringToDate(String dateString, String formatter) throws ParseException {
        if (StringUtils.isEmpty(dateString)) {
            return new Date(System.currentTimeMillis());
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatter, Locale.CHINA);
        Date date = null;
        date = sdf.parse(dateString);
        return date;
    }

    public static String fromXMLGregorianCalendarToString(XMLGregorianCalendar calendar, String formatter) {
        Date date = fromXMLGregorianCalendarToDate(calendar);
        return fromDateToString(date, formatter);
    }

    public static String fromXMLGregorianCalendarToHHMMString(XMLGregorianCalendar calendar) {
        String dateStr = String.format("%02d", calendar.getHour()) + ":" + String.format("%02d", calendar.getMinute());
        return dateStr;
    }

    public static Calendar fromXMLGregorianCalendarToCalendar(XMLGregorianCalendar calendar) {
        Calendar myCalendar = Calendar.getInstance();
        GregorianCalendar gCalendar = calendar.toGregorianCalendar();
        myCalendar.setTime(gCalendar.getTime());
        return myCalendar;
    }

    public static String fromCalendarToString(Calendar calendar, String formatter) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter, Locale.CHINA);
        String dateStr = sdf.format(calendar.getTime());
        return dateStr;
    }

    public static Date fromCalendarDate(Calendar calendar, String formatter) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter, Locale.CHINA);
        String dateStr = sdf.format(calendar.getTime());

        return DateUtil.fromStringToDate(dateStr, formatter);
    }

    public static XMLGregorianCalendar fromStringToXMLGregorianCalendar(String dateString, String formatter) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        Date date = null;
        try {
            date = fromStringToDate(dateString, formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            return null;
        }
        XMLGregorianCalendar xgcal = null;
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return xgcal;
    }

    public static boolean isTheFirstGreaterThanTheSecond(Calendar first, Calendar second) {
        if (first == null || second == null) {
            return true;
        }
        return first.after(second);
    }

    public static boolean isTheFirstLessThanTheSecond(Calendar first, Calendar second) {
        if (first == null || second == null) {
            return true;
        }
        return first.before(second);
    }

    public static boolean isTheFirstEqualTheSecond(Calendar first, Calendar second) {
        if (first == null || second == null) {
            return true;
        }
        return first.equals(second);
    }

    public static boolean isGreaterThanNow(Calendar calendar) {
        return isTheFirstGreaterThanTheSecond(Calendar.getInstance(), calendar);
    }

    public static Date addMinutes(Date date, int minutes) {
        return new Date(date.getTime() + minutes * 60 * 1000);
    }

    public static Calendar addDays(Calendar date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime().getTime() + days * 86400000L);
        return c;
    }

    public static Calendar fromDataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static String fromDateToString(Date date, String formatter) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter, Locale.CHINA);
        return sdf.format(date);
    }

    // 将秒 和 毫秒 改为0
    public static XMLGregorianCalendar makeSecondAndMillionSecondZero(XMLGregorianCalendar calendar) {
        Date date = fromXMLGregorianCalendarToDate(calendar);
        long millioinSeconds = (date.getTime() / 1000) / 60;
        date = new Date(millioinSeconds * 60 * 1000);
        return fromDateToXMLGregorianCalendar(date);
    }

    public static String dateFormat(String strDate, String formatter, String newFormatter) throws ParseException {
        Date date = fromStringToDate(strDate, formatter);
        SimpleDateFormat sdf = new SimpleDateFormat(newFormatter, Locale.CHINA);
        return sdf.format(date);
    }

    /**
     * 将Date类转换为XMLGregorianCalendar
     *
     * @param date
     * @return
     */
    public static XMLGregorianCalendar dateToXmlDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DatatypeFactory dtf = null;
        try {
            dtf = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        if (dtf == null) {
            return null;
        }
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
        dateType.setYear(cal.get(Calendar.YEAR));
        // 由于Calendar.MONTH取值范围为0~11,需要加1
        dateType.setMonth(cal.get(Calendar.MONTH) + 1);
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
        dateType.setMinute(cal.get(Calendar.MINUTE));
        dateType.setSecond(cal.get(Calendar.SECOND));
        return dateType;
    }

    /**
     * 判断是否无效的时间， //判断是否是超级小的时间， dot net 最小的时间是 0000-00-00 00：00:00
     *
     * @param date 时间字符串
     * @param formatter 时间格式
     * @return false=无效 true=有效
     * @throws ParseException
     */
    public static boolean isDateValid(String date, String formatter) throws ParseException {
        Date date1 = fromStringToDate(date, formatter);
        if (date1 == null) {
            return false;
        }
        return date1.getTime() > (System.currentTimeMillis() - 31536000000L);
    }

    /**
     * @param date
     * @return
     */
    public static String convertDateToChina(int date) {
        String result = "";
        date = date - 1;
        switch (date) {
            case 1:
                result = "周一";
                break;
            case 2:
                result = "周二";
                break;
            case 3:
                result = "周三";
                break;
            case 4:
                result = "周四";
                break;
            case 5:
                result = "周五";
                break;
            case 6:
                result = "周六";
                break;
            case 0:
                result = "周日";
                break;
        }
        return result;
    }

    // 日期类型转化
    public static XMLGregorianCalendar fromCalendarToXMLGregorianCalendar(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        Date date = calendar.getTime();
        return fromDateToXMLGregorianCalendar(date);
    }

    // 把UTC 时间转化为本地之间
    public static String utc2Local(String utcTime, String utcTimePatten, String localTimePatten) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));// 时区定义并进行时间获取
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return utcTime;
        }
        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten, Locale.CHINA);
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    // 获取今天是星期几. 星期一， 星期二...
    public static String getWeekName() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.CHINA);
    }

    // 获取date是星期几. 星期一， 星期二...
    public static String getWeekName(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.CHINA);
    }

    /**
     * 判断信用卡时间有效期
     *
     * @param year 信用卡有效年
     * @param month 信用卡有效月
     * @return
     */
    public static boolean isYearMonthAfterNowForCreditCard(String year, String month) {
        boolean isYearMonthAfterNow = false;
        try {
            String dateStr = "20" + year + month;
            isYearMonthAfterNow = DateUtil.fromStringToDate(dateStr, YYYYMM).after(new Date());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isYearMonthAfterNow;
    }

    public static long getMillionSeconds(String date, String formatter) {
        try {
            Calendar c = fromStringToCalendar(date, formatter);
            return c.getTime().getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 时间时区转化
     *
     * @param fromTime 初始时间
     * @param fromTimeZone 初始时区
     * @param toTimeZone 目标时区
     * @return
     */
    public static long transTimeZone(long fromTime, TimeZone fromTimeZone, TimeZone toTimeZone) {
        return fromTime - fromTimeZone.getRawOffset() + toTimeZone.getRawOffset();
    }

    public static String fromLongDateToString(long dateTime, String formatter) {
        if (dateTime <= 0) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateTime);
        return fromCalendarToString(calendar, formatter);
    }

    /**
     * 获取格式化的时间 输出格式：2015-08-04 20:55:35
     */
    public static String getFormatDate() {
        Date date = new Date();
        long times = date.getTime();// 时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return formatter.format(date);
    }

    /**
     * 获取格式化的时间 输出格式：2015-08-04 20:55:35
     */
    public static String getFormatDate(String pattern) {
        Date date = new Date();
        long times = date.getTime();// 时间戳
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.CHINA);
        return formatter.format(date);
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 将日期字符串转换为Date对象(使用最常用的格式)
     *
     * @param date 日期字符串
     */
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat(DateUtil.YYYY_MM_DD_HH_mm_ss, Locale.CHINA).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将日期字符串转换为Date对象
     *
     * @param date 日期字符串
     * @param format 日期字符串的格式
     */
    public static Date parseDate(String date, String format) {
        try {
            return new SimpleDateFormat(format, Locale.CHINA).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 得到两个日期相差的天数
     *
     * @param beginDate 开始时间
     * @param endDate 结束时间
     */
    public static long betweenDay(Date beginDate, Date endDate) {
        return between(beginDate, endDate, DateUnitEnum.DAY);
    }

    /**
     * 得到两个日期相差的小时数
     *
     * @param beginDate 开始时间
     * @param endDate 结束时间
     */
    public static long betweenHour(Date beginDate, Date endDate) {
        return between(beginDate, endDate, DateUnitEnum.HOUR);
    }

    /**
     * 得到两个日期相差的分钟数
     *
     * @param beginDate 开始时间
     * @param endDate 结束时间
     */
    public static long betweenMinute(Date beginDate, Date endDate) {
        return between(beginDate, endDate, DateUnitEnum.MINUTE);
    }

    /**
     * 判断两个日期相差的时长
     *
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @param dateUnit 时间单位{@link DateUnitEnum}
     * @return 时长差 相差 天、小时、分钟等
     */
    public static long between(Date beginDate, Date endDate, DateUnitEnum dateUnit) {
        return (endDate.getTime() - beginDate.getTime()) / dateUnit.getMillis();
    }

    /**
     * 获取当前日期是周几
     *
     * @param dateStr
     * @param formater
     * @return 1: 周日 2： 周一 3：周二 4：周三 5：周四 6：周五 7： 周日 如果出现异常， 返回1， 周日
     */
    public static int dayOfWeek(String dateStr, String formater) {
        try {
            Calendar calendar = fromStringToCalendar(dateStr, formater);
            return calendar.get(Calendar.DAY_OF_WEEK);
        } catch (Exception ex) {
            return 1;
        }
    }

}
