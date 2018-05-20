package com.ding.webcollector_boot.controller;

import com.ding.webcollector_boot.dao.LiveResultDao;
import com.ding.webcollector_boot.domain.LiveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping
    public String testskip(){
        return "index";
    }

    @GetMapping("/game")
    public String testdemo(Model model){
        String defultGameType = "英雄联盟";
        List<String> gameTypeList = liveResultDao.findGameTypeList(50);
        List<LiveResult> liveResults = liveResultDao.findAllByGameType(defultGameType);
        model.addAttribute("gameTypeList",gameTypeList);
        model.addAttribute("gameDetails",liveResults);
        return "index";
    }
    @GetMapping("/game/{gameType}")
    public ModelAndView listGameDetails(@PathVariable(value = "gameType")String gameType){
        ModelAndView index2 = new ModelAndView("index");
        List<String> gameTypeList = liveResultDao.findGameTypeList(50);
        List<LiveResult> liveResults = liveResultDao.findAllByGameType(gameType);
        index2.addObject("gameTypeList",gameTypeList);
        index2.addObject("gameDetails",liveResults);
        return index2;
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
        List<String> gameTypeList = liveResultDao.findGameTypeList(50);
        return gameTypeList;
    }
}
