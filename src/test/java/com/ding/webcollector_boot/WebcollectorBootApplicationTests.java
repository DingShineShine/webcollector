package com.ding.webcollector_boot;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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
}
