package com.ding.webcollector_boot.pipline;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author Ding
 * @create 2018/5/16
 * @description :
 */
@Component
public class LivePipline implements Pipeline {
    @Autowired
    private LiveResultDao liveResultDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<LiveResult> liveResults = resultItems.get("liveResults");
        if(liveResults!=null){
            for (LiveResult liveResult : liveResults) {
                liveResultDao.save(liveResult);
            }
        }
    }
}
