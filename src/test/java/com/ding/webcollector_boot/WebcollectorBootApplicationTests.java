package com.ding.webcollector_boot;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import com.ding.webcollector_boot.fastjson.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebcollectorBootApplicationTests {
    @Autowired
    private LiveResultDao liveResultDao;


    @Test
    public void test33(){
        List<String> strings = liveResultDao.findGameTypeList(10);
        System.out.println(strings);
    }

    @Test
    public void test39(){
        List<LiveResult> ss = liveResultDao.findAllByGameType("炉石传说");
        System.out.println(ss);
    }

    @Test
    public void test34(){
        LiveResult liveResult = liveResultDao.findByLiveUrl("https://www.douyu.com/1327075");
        System.out.println(liveResult);
        Double i = new Double(0);
        i = liveResult.getHot();
        System.out.println(i);
    }

    @Test
    public void test43(){

    }

}
