package com.ding.webcollector_boot.pipline;

import com.ding.webcollector_boot.dao.XiongMaoResultDao;
import com.ding.webcollector_boot.domain.XiongmaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/15-21:24
 */
@Component
public class XiongmaoPipeline implements Pipeline {
    @Autowired
    private XiongMaoResultDao xiongmaoResultDao;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<XiongmaoResult> xiongMaoResults = resultItems.get("xiongMaoResults");
        if(xiongMaoResults!=null){
            xiongmaoResultDao.saveAll(xiongMaoResults);
        }
    }
}
