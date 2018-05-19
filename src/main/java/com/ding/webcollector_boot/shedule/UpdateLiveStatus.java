package com.ding.webcollector_boot.shedule;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/19-19:18
 */
@Component
public class UpdateLiveStatus {
    @Autowired
    private LiveResultDao liveResultDao;

    /**
     * 根据lastUpdate定时任务更新直播状态
     */
    @Scheduled(cron = "* 0/5 * * * ?")
    public void updateLiveStatus(){
      List<LiveResult> liveResults =  liveResultDao.findByLiveStatus("1");
        for (LiveResult liveResult : liveResults) {
            if(Duration.between(liveResult.getUpdateTime(),LocalDateTime.now()).toMinutes()>4){
                liveResult.setLiveStatus("0");
            }
        }
    }
}
