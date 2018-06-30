package com.ding.webcollector_boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ding.webcollector_boot.fastjson.Student;
import com.ding.webcollector_boot.observer.CronDateUtils;
import com.ding.webcollector_boot.observer.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.quartz.CronExpression;
import org.springframework.beans.BeanUtils;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.function.Predicate;
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
    public void test165() {
      String time1 = "2018-06-05T14:42:49.090+08:00";
        ZonedDateTime s = DateTimeUtil.getUtcZoneDateTime(time1);
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("Asia/Shanghai"));
        String format = s.format(shortFormatter);
        System.out.println(format);
    }

    @Test
    public void test174() {
        String ss = "{\"flownodeid\":\"3898TA00001708_5279\",\"creator\":\"zhouhm@fosun.com\",\"flowmess\":\"0\",\"receiver\":\"zhouhm@fosun.com\",\"appurl\":\"http://yidongbx-uat.fosun.com/?loginType=fosun&messageType=0&targetState=app.ap_fosun_task_await&targetParams=%7B%22formType%22%3A%222001%22%2C%22userOid%22%3A%224b1f4158-69bb-4293-bf77-27aa47e29691%22%2C%22formOID%22%3A%22bb3fcecc-7669-4556-9e1b-f8fd293b34d3%22%2C%22applicationOID%22%3A%222eb45758-a3af-4043-8441-8af153e752ce%22%2C%22referenceId%22%3A%22TA00001708%22%7D&state=STATE#/\",\"flowtitle\":\"复星待办事宜\",\"totalAmount\":55.0,\"ptpurl\":\"https://portal.fosun.com/bx-sit/#/sso/login?loginType=fosun&messageType=0&targetState=app.ap_fosun_task_await&targetParams=eyJmb3JtVHlwZSI6IjIwMDEiLCJ1c2VyT2lkIjoiNGIxZjQxNTgtNjliYi00MjkzLWJmNzctMjdhYTQ3ZTI5NjkxIiwiZm9ybU9JRCI6ImJiM2ZjZWNjLTc2NjktNDU1Ni05ZTFiLWY4ZmQyOTNiMzRkMyIsImFwcGxpY2F0aW9uT0lEIjoiMmViNDU3NTgtYTNhZi00MDQzLTg0NDEtOGFmMTUzZTc1MmNlIiwicmVmZXJlbmNlSWQiOiJUQTAwMDAxNzA4In0=&form_oid=bb3fcecc-7669-4556-9e1b-f8fd293b34d3\",\"formName\":\"差旅申请\",\"logincode\":\"zhouhm@fosun.com\",\"createdatetime\":\"2018-06-05T11:17:34.647+08:00\",\"flownodename\":\"周慧敏\",\"flowid\":\"TA00001708\"}";
        JSONObject heliosBacklogInfo = JSON.parseObject(ss);
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("Asia/Shanghai"));
        String createdatetime1 = heliosBacklogInfo.getString("createdatetime");
        String createDate = DateTimeUtil.getUtcZoneDateTime(createdatetime1).format(shortFormatter);
        System.out.println(createDate);
    }

    @Test
    public void test185() {
        /*Date now = new Date();
        System.out.println(CronDateUtils.getCron(now));*/

        String cron = "0 0 0/1 * * ?";

        Date cronDate = null;
        try {
            cronDate = CronDateUtils.getDate(cron);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("===================");
        System.out.println(cronDate.toString());
    }

    @Test
    public void test204() {
        String format = DateFormatUtil.format("0 0 8  1/5 * ?", new Date());
        try {
            Date parse = DateFormatUtil.parse("0 0 8  1/5 * ?", new Date().toString());
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(format);
    }


    @Test
    public void test219() {
        Date curTime = new Date();
        System.out.println(curTime);

        CronExpression expression;
        try
        {
            expression = new CronExpression("0 30 15 * * ?");
            Date newDate = expression.getNextValidTimeAfter(curTime);
            System.out.println(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test238() {
        ArrayList<String> strings = new ArrayList<>();

    }

    @Test
    public void test250() {
        JSONArray objects = JSON.parseArray("[60L,120L,180L]");
        System.out.println(objects);
    }

    @Test
    public void test256() {
        String name = this.getClass().getName();
        System.out.println(name);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(objectObjectHashMap.isEmpty());
    }

    @Test
    public void test261() {
        String s = "abcnbnmmi";
        String replace = s.replace("b", "a").replace("q", "a");
        System.out.println(replace);
    }

    @Test
    public void test267() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        dateTimeFormatter.withLocale(Locale.FRANCE);
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.out.println(format);
    }

    @Test
    public void test275() {
        Object[] a = new Object[5];
        a[0] = "01";
        a[1] = "12";
        a[2] = "23";
        this.insertToList(a,1,"33");
        Arrays.asList(a).forEach(System.out::println);
        this.deleteFromList(a,2);
        System.out.println("=========");
        Arrays.asList(a).forEach(System.out::println);
        System.out.println(a);
    }
    private Boolean insertToList(Object[] lists, int index,Object element){
        if (index < 0 || index >= lists.length) {
            return false;
        } else {
            for (int i = lists.length-2;i>index; i--) {
                lists[i+1] = lists[i];
            }
            lists[index] = element;
        }
        return true;
    }
    private Object deleteFromList(Object[] lists, int index){
        Object c;
        if(index<0 || index>=lists.length){
            throw new NoSuchElementException();
        }else{
            c = lists[index];
            for (int i = index; i < lists.length-2; i++) {
                lists[i] = lists[i+1];
            }
        }
        return c;
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


    @Test
    public void test408(){
        ArrayList<String> s1 = new ArrayList<>();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        ArrayList<String> s2 = new ArrayList<>();
//        s1.add("4");
//        s2.add("5");
//        s2.add("1");
        s2.add("1");
        s2.add("2");
        s2.add("3");
        boolean b = s1.retainAll(s2);
        System.out.println(b);
        System.out.println(s1);
    }

    @Test
    public void test426() {
        Student s = new Student("wang", 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add("studentName");
        try {
            Map<String, Object> map = this.transBean2Map(arrayList, s);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String,Object> transBean2Map(List params,Student s) throws Exception {
        return  Arrays.stream(Introspector.getBeanInfo(s.getClass()).getPropertyDescriptors()).collect(
                Collectors.partitioningBy(p -> params.contains(p.getName()))).get(true).stream().collect(
                Collectors.toMap(PropertyDescriptor::getName, x -> {
                    try {
                        return x.getReadMethod().invoke(s);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }));
    }

    @Test
    public void test459(){
		Student student = new Student("12", 1);
		Student student1 = new Student("13", 1);
		ArrayList<Student> students = new ArrayList<>();
		students.add(student);
		students.add(student1);
		String s = JSON.toJSON(students).toString();
//		System.out.println(s);
		List<Student> students1 = JSON.parseArray(s, Student.class);
		System.out.println(students1);

		/*String s = JSONObject.toJSONString(student);
		System.out.println(s);
		Student student1 = JSON.parseObject(s, Student.class);
		System.out.println(student1);*/
	}


}
