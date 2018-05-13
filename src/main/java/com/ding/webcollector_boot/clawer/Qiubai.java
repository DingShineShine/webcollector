package com.ding.webcollector_boot.clawer;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.Requester;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.jsoup.select.Elements;

import java.util.Random;

/**
 * @author ding
 * @Description
 * @date 2018/05/12-15:40
 */
public class Qiubai extends BreadthCrawler {
    /**
     * 构造一个基于伯克利DB的爬虫
     * 伯克利DB文件夹为crawlPath，crawlPath中维护了历史URL等信息
     * 不同任务不要使用相同的crawlPath
     * 两个使用相同crawlPath的爬虫并行爬取会产生错误
     *
     * @param crawlPath 伯克利DB使用的文件夹
     * @param autoParse 是否根据设置的正则自动探测新URL
     */
    public Qiubai(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("https://www.qiushibaike.com/");
        this.addRegex("https://www.qiushibaike.com/8hr/page/\\d+\\/");
        this.addRegex("https://www.qiushibaike.com/article/\\d+");
        setThreads(3);
        getConf().setTopN(100).setReadTimeout(5000).setConnectTimeout(5000);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        try {
            String url = page.url();
            if(page.matchUrl("https://www.qiushibaike.com/article/\\d+")){
                String text = page.select(".content").text();
                System.out.println(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        Qiubai crawler = new Qiubai("crawl", true);
        crawler.start(3);
    }
}
