package com.ding.webcollector_boot;

import org.junit.Test;
import us.codecraft.webmagic.selector.Html;

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
}
