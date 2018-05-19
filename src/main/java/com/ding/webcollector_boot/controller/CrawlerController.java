package com.ding.webcollector_boot.controller;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<LiveResult>> lookFor(@PathVariable(value = "gameType")String gameType){

        return null;
    }

    @GetMapping
    public String testskip(){
        return "test";
    }

    @GetMapping(path = "game/{gameType}")
    @ResponseBody
    public List<LiveResult> getGameType(@PathVariable(value = "gameType")String gameType){
        List<LiveResult> liveResults = liveResultDao.findAllByGameType(gameType);
        return liveResults;
    }

    @GetMapping(path = "game/{gameType}/{hot}")
    @ResponseBody
    public List<LiveResult> listByGameTypeAndHot(@PathVariable(value = "gameType")String gameType,@PathVariable(value = "hot")Integer hot){
        List<LiveResult> liveResults = liveResultDao.findByGameTypeAndHot(gameType, hot);
        return liveResults;
    }

    @GetMapping(path = "gametype/list")
    @ResponseBody
    public List<String> listGameType(){
        List<String> gameTypeList = liveResultDao.findGameTypeList(30);
        return gameTypeList;
    }



}
