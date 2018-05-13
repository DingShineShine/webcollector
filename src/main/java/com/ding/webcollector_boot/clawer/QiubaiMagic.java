package com.ding.webcollector_boot.clawer;

import org.springframework.remoting.soap.SoapFaultException;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

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

        if(page.getHtml().links().regex(LIST_URL).match()){

        }else{
            page.putField("content",page.getHtml().css(".content").get());
        }


        page.addTargetRequests(page.getHtml().links().regex("https://www.qiushibaike.com/article/\\d+").all());
        page.addTargetRequests(page.getHtml().links().regex("https://www.qiushibaike.com/8hr/page/\\d+\\/)").all());
        String url = "https://www.qiushibaike.com/article/\\d+";
        page.putField("content", page.getHtml().css(".content").get());
        String s = page.getHtml().xpath("/html/body/div[2]/div/div[1]/div[1]/a/div/span[1]").get();
        System.out.println(s);
        System.out.println(page);
        String content = page.getHtml().css(".content").get();
        System.out.println(content);

    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("www.qiushibaike.com").addCookie("__cur_art_index", ".qiushibaike.com")
                .addCookie("_xsrf", "www.qiushibaike.com").setCharset("Utf-8").setTimeOut(3000).setSleepTime(1000);
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://www.qiushibaike.com/")
                .addPipeline(new ConsolePipeline()).thread(5).run();

    }

}


