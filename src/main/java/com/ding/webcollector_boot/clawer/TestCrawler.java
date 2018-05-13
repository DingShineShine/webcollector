package com.ding.webcollector_boot.clawer;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-11:34
 */
@Slf4j
public class TestCrawler extends BreadthCrawler {
    public TestCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("https://www.douyu.com/xiaoan666");
//        this.addRegex("https://www.douyu.com/directory/game/\\w+");
//        this.addRegex("https://www.douyu.com\\d+");
        setThreads(5);
        getConf().setTopN(100).setConnectTimeout(500).setReadTimeout(5000);
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String url = page.url();
        log.error(url);
        try {
            if (page.matchUrl("https://www.douyu.com/xiaoan666") ) {
                Thread.sleep(new Random().nextLong());
                String title = page.select(".headline > h2:nth-child(1)").text();
                String player = page.select(".zb-name > h1:nth-child(1)").text();
                String hot = page.select(".hot-v").text();
                String gameType = page.select("a.head-room-tag:nth-child(3)").text();
                System.out.println(url);
                System.out.println("游戏分类" + gameType);
                System.out.println("直播标题" + title);
                System.out.println("主播名称" + player);
                System.out.println("直播人气" + hot);
            }
            crawlDatums.add(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        TestCrawler crawl = new TestCrawler("crawl", true);
        /*start crawl with depth of 4*/
        crawl.start(3);
    }
}
