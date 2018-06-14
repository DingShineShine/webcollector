package com.ding.webcollector_boot;

import org.quartz.CronExpression;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/06/08-20:10
 */
public class TimeUtils {
    public static List<ZonedDateTime> parseCron(String cronExpression, int pushCount, ZonedDateTime startPushtTime){
        int i = 0;
        List<ZonedDateTime> dates = new ArrayList<>();
        try {
            CronExpression cron = new CronExpression(cronExpression);
            while(i < pushCount){
                Date noticeStartTime = Date.from(startPushtTime.toInstant());
                dates.add(startPushtTime);
                startPushtTime = cron.getNextValidTimeAfter(noticeStartTime).toInstant().atZone(ZoneId.systemDefault());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }
}
