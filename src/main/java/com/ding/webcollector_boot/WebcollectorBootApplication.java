package com.ding.webcollector_boot;

import com.ding.webcollector_boot.clawer.DouYuMagic;
import com.ding.webcollector_boot.clawer.QiubaiMagic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

@SpringBootApplication
public class WebcollectorBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebcollectorBootApplication.class, args);
//        Spider.create(new DouYuMagic()).addPipeline(new ConsolePipeline()).thread(10).addUrl("https://www.douyu.com/directory").run();
        Spider.create(new QiubaiMagic()).addUrl("https://www.qiushibaike.com/")
                .addPipeline(new ConsolePipeline()).thread(5).run();
    }
}
