package com.ding.webcollector_boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.StopWatch;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-11:25
 */
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
    public void test149() {
        StopWatch ha = new StopWatch("ha");
        ha.start("123");
        BigDecimal bigDecimal = new BigDecimal("-13.1");
        System.out.println(bigDecimal.abs());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ha.stop();
        System.out.println(ha.shortSummary());
    }

    @Test
    public void test165() {
       String s = "123";
        String intern = s.intern();
    }

}
