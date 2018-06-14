package com.ding.webcollector_boot;

import com.ding.webcollector_boot.fastjson.Student;
import com.ding.webcollector_boot.service.impl.Cat;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.quartz.CronExpression;
import org.springframework.beans.BeanUtils;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-11:25
 */
@Slf4j
public class TestOne {
    @Test
    public void testone() {
        System.out.println(new Random().nextInt());
    }

    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        Html html = new Html("www.baidu.com");
        System.out.println(html);
    }

    @Test
    public void test4() {
        Html html = new Html("https://www.douyu.com/directory/game/LRSZQ");
        System.out.println(html);
    }

    @Test
    public void test5() {
        String s = "https://www.douyu.com/directory/game/\\w+";
        Html html = new Html("https://www.douyu.com/directory/game/LRSZQ");
        boolean match = html.links().regex(s).match();
        Selectable links = html.css("body").links();
        System.out.println(links);
        System.out.println(match);
    }

    @Test
    public void test49() {
        try {
            System.out.println(LocalDateTime.now());
            LocalDateTime now = LocalDateTime.now();
            Thread.sleep(6000);
            LocalDateTime now1 = LocalDateTime.now();
            long l = Duration.between(now, now1).toMinutes();
            System.out.println(l);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test6() {
        String s = "https://www.douyu.com/directory/game/\\w+";
        int i = s.lastIndexOf(".com/") + 5;

        String substring = s.substring(0, i);
        System.out.println(substring);
    }

    @Test
    public void test75() {
        Double number = 0.0;
        String hot = "1.1万";
        if (null != hot && hot.endsWith("万")) {
            number = Double.parseDouble(hot.substring(0, hot.length() - 1)) * 10000;
        }
        System.out.println(number);
    }

    @Test
    public void test86() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));

        }
    }

    @Test
    public void test94() {
        BigDecimal iniMoney = new BigDecimal("0.1");
        BigDecimal sumMoney = new BigDecimal("1");
        int count = 0;
        for (BigDecimal p = iniMoney; sumMoney.compareTo(p) >= 0; p = p.add(iniMoney)) {
            sumMoney = sumMoney.subtract(p);
            count++;
            System.out.println("remainingMoney:" + sumMoney);
        }
        System.out.println(count);
    }

    @Test
    public void test108() {
        double sumMoney = 1.0;
        int count = 0;
        double b = 0.1;
        for (double price = b; sumMoney - price > 0; price += b) {
            sumMoney -= price;
            count++;
        }
        System.out.println(count);
    }
    @Test
    public void test85() {
        String queryYear = LocalDate.now().getYear() + "";
        System.out.println(queryYear + "");
    }

    @Test
    public void test89(){
        List<String> a = new ArrayList<>();
        System.out.println(a.size());
    }

    @Test
    public void test140() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(StringUtils.isNotBlank(stringBuilder.toString()));
        if(StringUtils.isNotBlank(stringBuilder.toString())){
        }
    }

    @Test
    public void test128(){
        List<Student> students = new ArrayList<>();
        if(students!=null){
            for (Student student : students) {
                System.out.println(student.getStudentAge());
            }
        }

    }

    @Test
    public void test142(){
        String flowStatus = "3";
        String backlogTitle= "";
        switch (flowStatus){
            case "2" :
                backlogTitle="抄送";
                break;
            case "3" :
            case "8" :
                backlogTitle = "转发";
                break;
            case "4" :
                backlogTitle = "还款";
                break;
        }
        System.out.println(backlogTitle);
    }

    @Test
    public void test161(){
        List<String> a = new ArrayList<>();
        a.add("hong");
        a.add("ming");
        a.add("fang");
        Iterator<String> iterator = a.iterator();
        StringBuilder s = new StringBuilder();
        //1 .
        while (iterator.hasNext()){
            s.append(iterator.next()).append(";");
        }
        System.out.println(s);
        // 2.
        String aStr = a.toString();
        String ss = aStr.substring(1, aStr.length() - 1).replaceAll(", ", ";");
        System.out.println(ss);
    }

    @Test
    public void test224() throws ParseException {
        int i = 0;
        int pushCount = 3;
        String cronExpression = "0 0 8 1/3 * ?";
        Date startPushtTime = Date.from(ZonedDateTime.now(ZoneId.systemDefault()).toInstant());
        List<Date> dates = new ArrayList<>();
        CronExpression cron = new CronExpression(cronExpression);
        while(i < pushCount){
            startPushtTime = cron.getNextValidTimeAfter(startPushtTime);
            dates.add(startPushtTime);
            i++;
        }
        for (Date date : dates) {
            System.out.println(date);
        }
    }

    @Test
    public void test244(){
        Student student = new Student();
        int i = 0;
        List<Student> list = new ArrayList<>();
        student.setStudentName("wa");
        while (i<3){
            Student s = new Student();
            BeanUtils.copyProperties(student,s);
            s.setStudentAge(i);
            list.add(s);
            i ++;
        }
        for (Student student1 : list) {
            System.out.println(student1);
        }
    }


    @Test
    public void test264(){
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
        String cronExpression = "0 0 8 1/3 * ?";
        int count = 3;
        List<ZonedDateTime> zonedDateTimes = TimeUtils.parseCron(cronExpression, count, now);
        for (ZonedDateTime zonedDateTime : zonedDateTimes) {
            System.out.println(zonedDateTime);
        }
    }

    @Test
    public void test243(){
        int i = 0;
        int pushCount = 3;
        String cronExpression = "0 0 8 1/5 * ?";
        ZonedDateTime startPushtTime = ZonedDateTime.now(ZoneId.systemDefault()).plusSeconds(864000);
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
        for (ZonedDateTime date : dates) {
            System.out.println(date);
        }
    }

    @Test
    public void test266(){
        Predicate<Student> p1 = (Student s) -> {
            if(s.getStudentAge()>1){
                return true;
            }
            return false;
        };
        List<Student> students = Arrays.asList(new Student("wang", 2), new Student("li", 1));
        filterStudent(students,p1);

    }

    public void filterStudent(List<Student> students,Predicate<Student> p){
        for (Student student : students) {
            if(p.test(student)){
                System.out.println(student.getStudentName() + "," +student.getStudentAge());
            }
        }
    }

}
