package com.ding.webcollector_boot.clawer;

import com.ding.webcollector_boot.dao.QiuBaiResultDao;
import com.ding.webcollector_boot.domain.QiuBaiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-11:58
 */
@Component
public class QiubaiMagic implements PageProcessor {
    private static final String LIST_URL = "https://www.qiushibaike.com/8hr/page/\\d+\\/";
    @Autowired
    private QiuBaiResultDao qiuBaiResultDao;

    @Override
    public void process(Page page) {
        try {
            page.addTargetRequests(page.getHtml().links().regex(LIST_URL).all());
            List<String> all = page.getHtml().links().regex("https://www.qiushibaike.com/article/\\d+").all();
            for (String detailUrl : all) {
                Html html = new Html(detailUrl);
                String content = html.css(".content").get();
                String author = html.css(".author > a:nth-child(2) > h2:nth-child(1)").get();
                String hot = html.css("i.number:nth-child(1)").get();
                String picUrl = html.css(".thumb > img:nth-child(1)").get();
                qiuBaiResultDao.save(new QiuBaiResult(null, author, content, hot, picUrl, LocalDateTime.now(), LocalDateTime.now()));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setDomain("www.qiushibaike.com")
                .addCookie("_xsrf", "www.qiushibaike.com")
                .addCookie("__cur_art_index", ".qiushibaike.com")
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")
                .setCharset("Utf-8").setTimeOut(3000).setSleepTime(1000);
    }

  /*  public static void main(String[] args) {
        Spider.create(new QiubaiMagic()).addUrl("https://www.qiushibaike.com/")
                .addPipeline(new ConsolePipeline()).thread(5).run();

    }*/

}


