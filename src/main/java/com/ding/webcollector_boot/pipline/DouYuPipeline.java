package com.ding.webcollector_boot.pipline;

import com.ding.webcollector_boot.dao.DouyuResultDao;
import com.ding.webcollector_boot.domain.DouYuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author Ding
 * @create 2018/5/14
 * @description :
 */
@Component
public class DouYuPipeline implements Pipeline {
    @Autowired
    private  DouyuResultDao douyuResultDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<DouYuResult> douYuResults = resultItems.get("douYuResultList");
        if(douYuResults!=null){
            douyuResultDao.saveAll(douYuResults);
        }
    }
}
