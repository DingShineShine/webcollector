package com.ding.webcollector_boot.service.impl;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/20-12:05
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private LiveResultDao liveResultDao;

    @Override
    public List<String> listMenu(){
        List<String> gameTypeList = liveResultDao.findGameTypeList(20);
        return gameTypeList;
    }

}
