package com.ding.webcollector_boot.controller;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/16-21:48
 */
@Controller("/")
public class CrawlerController {

    @Autowired
    private LiveResultDao liveResultDao;

    @GetMapping(path = "/{gameType}")
    public void lookFor(@PathVariable(value = "gameType")String gameType){

    }

    @GetMapping
    public String testskip(){
        return "test";
    }

    @GetMapping(path = "public/{gameType}")
    @ResponseBody
    public List<LiveResult> getGameType(@PathVariable(value = "gameType")String gameType){
        List<LiveResult> liveResults = liveResultDao.findByGameType(gameType);
        return liveResults;
    }

    @GetMapping(path = "public/{gameType}/{hot}")
    @ResponseBody
    public List<LiveResult> listByGameTypeAndHot(@PathVariable(value = "gameType")String gameType,@PathVariable(value = "hot")Integer hot){
        List<LiveResult> liveResults = liveResultDao.findByGameTypeAndHot(gameType, hot);
        return liveResults;
    }

}
