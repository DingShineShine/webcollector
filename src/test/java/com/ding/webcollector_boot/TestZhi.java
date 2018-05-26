package com.ding.webcollector_boot;

import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author ding
 * @Description
 * @date 2018/05/26-0:26
 */
public class TestZhi implements PageProcessor {
    static final String MAIN_URL = "https://www.zhihu.com/question/37787176";

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return Site.me().setCharset("utf-8");
    }
}
