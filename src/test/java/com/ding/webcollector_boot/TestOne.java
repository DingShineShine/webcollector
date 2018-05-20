package com.ding.webcollector_boot;

import org.junit.Test;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-11:25
 */
public class TestOne {
    @Test
    public void testone(){
        System.out.println(new Random().nextInt());
    }

    @Test
    public void test2(){
        for (int i = 0; i <20; i++){
            System.out.println(i);
        }
    }
    @Test
    public void test3(){
        Html html = new Html("www.baidu.com");
        System.out.println(html);
    }

    @Test
    public void test4(){
        Html html = new Html("https://www.douyu.com/directory/game/LRSZQ");
        System.out.println(html);
    }

    @Test
    public void test5(){
        String s = "https://www.douyu.com/directory/game/\\w+";
        Html html = new Html("https://www.douyu.com/directory/game/LRSZQ");
        boolean match = html.links().regex(s).match();
        Selectable links = html.css("body").links();
        System.out.println(links);
        System.out.println(match);
    }

    @Test
    public void test49(){
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
    public void test6(){
        String s = "https://www.douyu.com/directory/game/\\w+";
        int i = s.lastIndexOf(".com/")+5;

        String substring = s.substring(0, i);
        System.out.println(substring);
    }

    @Test
    public void test75(){
        Double number = 0.0;
        String hot = "1.1万";
        if(null != hot && hot.endsWith("万")){
            number = Double.parseDouble(hot.substring(0, hot.length() - 1) )*10000;
        }
        System.out.println(number);
    }
}
