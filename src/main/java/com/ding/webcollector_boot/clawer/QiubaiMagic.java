package com.ding.webcollector_boot.clawer;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-11:58
 */
public class QiubaiMagic implements PageProcessor {
    private static final String LIST_URL = "https://www.qiushibaike.com/8hr/page/\\d+\\/";
    private static final String CONTENT_URL = "https://www.qiushibaike.com/article/\\d+";

//    private Site site  = Site.me().addCookie("__cur_art_index",".qiushibaike.com")
//            .addCookie("_xsrf","www.qiushibaike.com").setCharset("Utf-8").setTimeOut(3000).setSleepTime(1000);


    @Override
    public void process(Page page) {
        try {
            if(page.getUrl().regex(LIST_URL).match()){
                page.addTargetRequests(page.getHtml().links().regex(LIST_URL).all());
            }else if(page.getUrl().regex(CONTENT_URL).match()){
                page.putField("content",page.getHtml().css(".content").get());
            }
        }catch (Exception e){
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

    public static void main(String[] args) {
        Spider.create(new QiubaiMagic()).addUrl("https://www.qiushibaike.com/")
                .addPipeline(new ConsolePipeline()).thread(5).run();

    }

}


