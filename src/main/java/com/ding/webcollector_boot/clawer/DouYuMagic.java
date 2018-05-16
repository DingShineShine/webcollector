package com.ding.webcollector_boot.clawer;

import com.ding.webcollector_boot.domain.LiveResult;
import com.ding.webcollector_boot.pipline.LivePipline;
import com.ding.webcollector_boot.utils.HtmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-14:44
 */
@Component
@Slf4j
public class DouYuMagic implements PageProcessor {
    private static final String DETAIL_LIST_URL = "https://www.douyu.com/directory/game/\\w+";
    private static final String MAIN_PAGE = "https://www.douyu.com/directory";

    @Autowired
    private LivePipline livePipline;

    @Override
    public void process(Page page) {
        try {
            if (page.getUrl().get().equalsIgnoreCase(MAIN_PAGE)) {
                List<String> gameTypeList = page.getHtml().css("#live-list-content").links().all();
                page.addTargetRequests(gameTypeList);
            }
            if (page.getUrl().regex(DETAIL_LIST_URL).match()) {
                String url = page.getUrl().get();
                log.info("爬取游戏详情列表页链接为:{}", url);
                List<String> gameDetails = page.getHtml().css("#live-list-contentbox").links().all();
                List<LiveResult> liveResults = new ArrayList<>();
                if (gameDetails.size() >= 20) {
                    for (int i = 0; i < gameDetails.size(); i++) {
                        String cssGameType = "#live-list-contentbox > li:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)";
                        String cssPlayer = "#live-list-contentbox > li:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(2) > p:nth-child(2) > span:nth-child(1)";
                        String cssTitle = "#live-list-contentbox > li:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h3:nth-child(1)";
                        String cssHot = "#live-list-contentbox > li:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(2) > p:nth-child(2) > span:nth-child(2)";
                        String cssKeyWord = "#live-list-contentbox > li:nth-child(" + i + ") > a:nth-child(1) > div:nth-child(3)";
                        String cssPicUrl = "#live-list-contentbox > li:nth-child(1) > a:nth-child(1) > span:nth-child(1) > img:nth-child(4)";
                        String cssLiveUrl = "#live-list-contentbox > li:nth-child(" + i + ")";

                        String gameType = page.getHtml().css(cssGameType, "text").toString();
                        String player = page.getHtml().css(cssPlayer, "text").toString();
                        String title = page.getHtml().css(cssTitle, "text").get();
                        String liveUrl = url.substring(0, url.lastIndexOf(".com/") + 5) + page.getHtml().css(cssLiveUrl, "data-rid").get();
                        if (gameType != null && player != null && title != null ) {
                            String hot = page.getHtml().css(cssHot, "text").get();
                            String keyWord = page.getHtml().css(cssKeyWord).toString();
                            String picUrl = page.getHtml().css(cssPicUrl, "data-original").get();
                            LiveResult douYuResult = new LiveResult(null, player, title,"1", hot, gameType, HtmlUtils.delHTMLTag(keyWord), picUrl, liveUrl);
                            liveResults.add(douYuResult);
                        }
                    }
                }
                page.putField("liveResultList", liveResults);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return Site.me().setDomain(MAIN_PAGE)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")
                .setSleepTime(3000).setRetryTimes(3).setRetrySleepTime(1000).setCharset("utf-8");
//                .addHeader("Cookie", "dy_did=72678967c679cf70ed0a8dd800061501; acf_did=72678967c679cf70ed0a8dd800061501; smidV2=201805131135514c9446e16928b0365f10f093381be09a002c3b3b59c6263b0; acf_uid=193790845; acf_username=193790845; acf_nickname=%E6%A0%B8%E6%A1%8309631; acf_ltkid=74155997; acf_auth=f5c0ji3imrOKZYbtmtdr7D7TNBk2gsX4rk4pIcgKcrPTB7Daiu%2F86Vjhb%2FZhRZqYls%2FbNQPtxVYosWwwvseiHV0vnv3Jl9tuQg5bfQymjXmpvn7dvhDgSg8; wan_auth37wan=5468560d37b6wA0gJ1qX6aLNHBVvYz%2FU%2FsCCUrYTpoRSoaTT8bCsG%2Bsvn%2FEuRxmpLu4GPYsGee5cl3Ho%2FWYojOLtwFy%2BZGVdtsF9ZqyI9LHMky%2FfPe4; acf_own_room=0; acf_groupid=1; acf_phonestatus=0; acf_ct=0; acf_biz=1; acf_stk=31b975aa8363ad60; PHPSESSID=4aijlqbt033uill71a532l6ca7");
    }


    public void run() {
        try {
            log.info("斗鱼爬虫启动");
            Spider.create(new DouYuMagic()).addPipeline(livePipline).thread(30).addUrl(MAIN_PAGE).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
