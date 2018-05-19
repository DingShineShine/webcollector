package com.ding.webcollector_boot.clawer;

import com.ding.webcollector_boot.domain.LiveResult;
import com.ding.webcollector_boot.pipline.LivePipline;
import com.ding.webcollector_boot.utils.HtmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.time.LocalDateTime;
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
    private LivePipline livePipline;

    @Override
    public void process(us.codecraft.webmagic.Page page) {
        try {
            if (page.getUrl().get().equalsIgnoreCase(MAIN_PAGE)) {
                List<String> gameTypes = page.getHtml().css(".sort-menu").links().all();
                page.addTargetRequests(gameTypes);
            }
            if (page.getUrl().regex(DETAIL_LIST_URL).match()) {
                String url = page.getUrl().get();
                log.info("爬取游戏详情列表页链接为:{}", url);
                List<String> gameDetails = page.getHtml().css("#sortdetail-container").links().all();
                List<LiveResult> liveResults = new ArrayList<>();
                if (gameDetails.size() > 20) {
                    for (int i = 0; i < gameDetails.size(); i++) {
                        String cssGameType = ".header-title-secondname";
                        String cssPlayer = "li.video-list-item:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(2) > span:nth-child(2)";
                        String cssTitle = "li.video-list-item:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(2) > span:nth-child(1)";
                        String cssHot = "li.video-list-item:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(2) > span:nth-child(3)";
                        String cssKeyWord = "li.video-list-item:nth-child(" + i + ") > div:nth-child(2) > div:nth-child(1)";
                        String cssPicUrl = "li.video-list-item:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(1) > img:nth-child(1)";
                        String cssLiveUrl = "li.video-list-item:nth-child(" + i + ") > a:nth-child(1)";

                        String gameType = page.getHtml().css(cssGameType, "text").toString();
                        String player = page.getHtml().css(cssPlayer, "text").toString();
                        String title = page.getHtml().css(cssTitle, "text").get();
                        String liveUrl = url.substring(0, url.lastIndexOf(".tv/") + 3) + page.getHtml().css(cssLiveUrl, "href").get();
                        if (gameType != null && player != null && title != null) {
                            String hot = page.getHtml().css(cssHot, "text").get();
                            int number = 0;
                            if(null != hot && hot.endsWith("万")){
                                number = Integer.parseInt(hot.substring(0, hot.length() - 1) + "0000");
                            }else if(hot!=null){
                                number = Integer.parseInt(hot);
                            }
                            String keyWord = page.getHtml().css(cssKeyWord).toString();
                            String picUrl = page.getHtml().css(cssPicUrl, "data-original").get();
                            LiveResult liveResult = new LiveResult(null, player, title, "1", number, gameType, HtmlUtils.delHTMLTag(keyWord), picUrl, liveUrl,LocalDateTime.now());
                            liveResults.add(liveResult);
                        }
                    }
                }
                page.putField("liveResults", liveResults);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Site getSite() {
        return Site.me().setDomain(MAIN_PAGE)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")
                .setSleepTime(3000).setRetryTimes(3).setRetrySleepTime(1000).setCharset("utf-8").setRetryTimes(3);
    }

    public void run() {
        try {
            log.info("熊猫爬虫启动");
            Spider.create(new XiongMaoMagic()).addPipeline(livePipline).thread(30).addUrl(MAIN_PAGE).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
