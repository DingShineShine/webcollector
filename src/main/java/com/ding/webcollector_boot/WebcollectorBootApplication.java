package com.ding.webcollector_boot;

import com.ding.webcollector_boot.clawer.DouYuMagic;
import com.ding.webcollector_boot.pipline.DouYuPipeline;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = {"com.ding.webcollector_boot.dao"})
public class WebcollectorBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebcollectorBootApplication.class, args);
    }
}
