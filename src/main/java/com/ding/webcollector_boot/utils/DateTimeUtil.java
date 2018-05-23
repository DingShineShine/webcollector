package com.ding.webcollector_boot.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式处理工具类
 * Created by jiaquan on 2017/5/16.
 */
public class DateTimeUtil {
    private static final Logger log = LoggerFactory.getLogger(DateTimeUtil.class);

    /**
     * 将UTC时间字符（例如：2017-11-21T11:08:12Z）传时间转为北京时间
     * @param utcDateTimeStr
     * @return
     */
    public static ZonedDateTime getUtcZoneDateTime(String utcDateTimeStr){
        DateTimeFormatter standardFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        if(null==utcDateTimeStr){
            return null;
        }
        ZonedDateTime utcDateTime = null;
        if(utcDateTimeStr.contains("T")){
            utcDateTime = ZonedDateTime.parse(utcDateTimeStr, DateTimeFormatter.ISO_DATE_TIME);
        }else {
            if(utcDateTimeStr.length()>10){
                utcDateTime = ZonedDateTime.parse(utcDateTimeStr, standardFormatter);
            }else {
                utcDateTimeStr = utcDateTimeStr.substring(0,10);
                utcDateTimeStr = utcDateTimeStr+"T00:00:00Z";
                utcDateTime = ZonedDateTime.parse(utcDateTimeStr, DateTimeFormatter.ISO_DATE_TIME);
            }
        }
        return utcDateTime;
    }

    /**
     * 将北京时间字符串（例如：2017-11-21 11:07:58）转为UTC时间
     * @param beijingDateTimeStr
     * @return
     */
    public static ZonedDateTime changeBeijingToUTC(String beijingDateTimeStr){
        DateTimeFormatter beijingFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai"));
        if(StringUtils.isBlank(beijingDateTimeStr)){
            return null;
        }
        ZonedDateTime beijingDateTime = ZonedDateTime.parse(beijingDateTimeStr, beijingFormatter);
        return beijingDateTime.withZoneSameInstant(ZoneId.of("UTC"));
    }

    /**
     * 将北京时间字符串（例如：2017-11-21 11:07:58）转为2017-11-21格式
     * @param beijingDateTimeStr
     * @return
     */
    public static String toShortStrOfBeijing(String beijingDateTimeStr){
        DateTimeFormatter beijingFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("Asia/Shanghai"));
        if(StringUtils.isBlank(beijingDateTimeStr)||beijingDateTimeStr.length()<11){
            return beijingDateTimeStr;
        }
        ZonedDateTime beijingDateTime = ZonedDateTime.parse(beijingDateTimeStr, beijingFormatter);
        return beijingDateTime.format(shortFormatter);
    }

    /**
     * 将北京时间字符串（例如：2017-11-21 11:07:58）转为20171121格式
     * @param beijingDateTimeStr
     * @return
     */
    public static String toVeryShortStrOfBeijing(String beijingDateTimeStr){
        DateTimeFormatter beijingFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.of("Asia/Shanghai"));
        if(StringUtils.isBlank(beijingDateTimeStr)||beijingDateTimeStr.length()<11){
            return beijingDateTimeStr;
        }
        ZonedDateTime beijingDateTime = ZonedDateTime.parse(beijingDateTimeStr, beijingFormatter);
        return beijingDateTime.format(shortFormatter);
    }

    /**
     * 转换时间字符串为ZonedDateTime
     * @param dateTimeStr
     * @return
     */
    public static ZonedDateTime parseDateTime(String dateTimeStr){
        DateTimeFormatter standardFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        ZonedDateTime beijingDateTime = ZonedDateTime.parse(dateTimeStr, standardFormatter);
        return beijingDateTime;
    }

    /**
     * ZonedDateTime转为时间字符串(2018-01-19 11:02:54)
     * @Author jiaquan
     * @param zonedDateTime 待转换的时间
     * @param zoneId 转换后时间的时区
     * @return
     */
    public static String formatDateTime(ZonedDateTime zonedDateTime, ZoneId zoneId){
        if(null==zonedDateTime){
            return null;
        }
        if(null==zoneId){
            zoneId = ZoneId.systemDefault();
        }
        DateTimeFormatter standardFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(zoneId);
        String timeStr = zonedDateTime.format(standardFormatter);
        return timeStr;
    }
}
