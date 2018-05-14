package com.ding.webcollector_boot;

import com.ding.webcollector_boot.clawer.DouYuMagic;
import com.ding.webcollector_boot.pipline.DouYuPipeline;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

@SpringBootApplication
@ComponentScan
public class WebcollectorBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebcollectorBootApplication.class, args);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Spider.create(new DouYuMagic()).addPipeline(new DouYuPipeline()).thread(10).addUrl("https://www.douyu.com/directory").run();
    }
}
