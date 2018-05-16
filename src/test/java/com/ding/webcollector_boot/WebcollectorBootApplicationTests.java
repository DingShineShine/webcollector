package com.ding.webcollector_boot;

import com.ding.webcollector_boot.dao.DemoDao;
import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebcollectorBootApplicationTests {
    @Autowired
    private LiveResultDao liveResultDao;
    @Autowired
    private DemoDao demoDao;
    @Test
    public void contextLoads() {
        LiveResult liveResult = null;
        try {
            liveResult = new LiveResult(null, "2", "1", "1", "4", "1", "1", "1", "1");
            demoDao.save(liveResult);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            List<LiveResult> byHot = liveResultDao.findByHot(liveResult.getHot());
            System.out.println("======================================" + byHot);
        }
    }
}
