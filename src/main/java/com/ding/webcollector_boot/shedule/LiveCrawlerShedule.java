package com.ding.webcollector_boot.shedule;

import com.ding.webcollector_boot.clawer.DouYuMagic;
import com.ding.webcollector_boot.clawer.XiongMaoMagic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ding
 * @Description
 * @date 2018/05/16-21:12
 */
@Component
@Slf4j
public class LiveCrawlerShedule {
    @Autowired
    private DouYuMagic douYuMagic;
    @Autowired
    private XiongMaoMagic xiongMaoMagic;

    @Scheduled(cron = "40 40 * * * ?")
    public void crawlerRun(){
        log.info("定时任务执行开始:{}",LocalDateTime.now());
        try {
            douYuMagic.run();
            xiongMaoMagic.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("定时任务执行结束{}",LocalDateTime.now());
    }
}
