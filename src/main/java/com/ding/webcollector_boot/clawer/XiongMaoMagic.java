package com.ding.webcollector_boot.clawer;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.ding.webcollector_boot.domain.DouYuResult;
import com.ding.webcollector_boot.domain.XiongmaoResult;
import com.ding.webcollector_boot.pipline.DouYuPipeline;
import com.ding.webcollector_boot.pipline.XiongmaoPipeline;
import com.ding.webcollector_boot.utils.HtmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/15-20:30
 */
@Component
@Slf4j
public class XiongMaoMagic implements PageProcessor {
    private static final String DETAIL_LIST_URL = "https://www.panda.tv/cate/\\w+";
    private static final String MAIN_PAGE = "https://www.panda.tv/cate?pdt=1.18.pheader-n.2.3mr2dtf5h5q";

    @Autowired
    private XiongmaoPipeline xiongmaoPipeline;

    @Override
    public void process(us.codecraft.webmagic.Page page) {
        try{
            if(page.getUrl().get().equalsIgnoreCase(MAIN_PAGE)){
                List<String> gameTypes = page.getHtml().css(".sort-menu").links().all();
                page.addTargetRequests(gameTypes);
            }
            if(page.getUrl().regex(DETAIL_LIST_URL).match()){
                String url = page.getUrl().get();
                log.info("爬取游戏详情列表页链接为:{}", url);
                List<String> gameDetails = page.getHtml().css("#sortdetail-container").links().all();
                List<XiongmaoResult> xiongmaoResults = new ArrayList<>();
                if(gameDetails.size()>20){
                    for (int i = 0; i < gameDetails.size() ; i++) {
                        String cssGameType = ".header-title-secondname";
                        String cssPlayer = "li.video-list-item:nth-child("+i+") > a:nth-child(1) > div:nth-child(2) > span:nth-child(2)";
                        String cssTitle = "li.video-list-item:nth-child("+i+") > a:nth-child(1) > div:nth-child(2) > span:nth-child(1)";
                        String cssHot = "li.video-list-item:nth-child("+i+") > a:nth-child(1) > div:nth-child(2) > span:nth-child(3)";
                        String cssKeyWord = "li.video-list-item:nth-child("+i+") > div:nth-child(2) > div:nth-child(1)";
                        String cssPicUrl = "li.video-list-item:nth-child("+i+") > a:nth-child(1) > div:nth-child(1) > img:nth-child(1)";
                        String cssLiveUrl = "li.video-list-item:nth-child("+i+") > a:nth-child(1)";

                        String gameType = page.getHtml().css(cssGameType, "text").toString();
                        String player = page.getHtml().css(cssPlayer, "text").toString();
                        String title = page.getHtml().css(cssTitle, "text").get();
                        String liveUrl = url.substring(0, url.lastIndexOf(".tv/")+4) + page.getHtml().css(cssLiveUrl, "href").get();
                        if (gameType != null && player != null && title != null ) {
                            String hot = page.getHtml().css(cssHot, "text").get();
                            String keyWord = page.getHtml().css(cssKeyWord).toString();
                            String picUrl = page.getHtml().css(cssPicUrl, "data-original").get();
                            XiongmaoResult xiongMaoResult = new XiongmaoResult(null, player, title, hot, gameType, HtmlUtils.delHTMLTag(keyWord), picUrl, liveUrl);
                            xiongmaoResults.add(xiongMaoResult);
                        }
                    }
                }
                page.putField("xiongMaoResults",xiongmaoResults);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("https://www.panda.tv/cate?pdt=1.18.pheader-n.2.3mr2dtf5h5q")
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")
                .setSleepTime(3000).setRetryTimes(3).setRetrySleepTime(1000).setCharset("utf-8")
                .addHeader("Cookie","pdftv1=d2f35|16314e16412|54cb|de41753c|10; __guid=108187779.1983762738600510700.1525063706114.8599; pdft=2018043012482815fd3d921c21d1e8a3741b50dbe35ca300670a02a36291d6; smidV9=2018043012482815fd3d921c21d1e8a3741b50dbe35ca300670a02a36291d6; R=r=137548590&u=CnaqnGi137548590&n=kzluwbblzethaff&le=&m=ZGpmAQx3AmN5ZQL=&im=nUE0pPHmDFHlEvHlEzx3YaOxnJ0hM3ZyZxLjZwH3ZQDjZmtjLzD3MQV5ATR4ZQR3AGZlLmN3MGZ5Lv5dpTp=&p=&i=; M=t=1525178319&v=1.0&mt=1525178319&s=313caeb8914abdd4c93dcff84d34cd72&ps=1f60c73064e09c3c18b67acee6e266ba; I=r%3D137548590%26t%3D988311bf59ec9f867570f471e73e3362; monitor_count=9");
    }

    public void run() {
        try {
            log.info("熊猫爬虫启动");
            Spider.create(new XiongMaoMagic()).addPipeline(xiongmaoPipeline).thread(30).addUrl(MAIN_PAGE).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
