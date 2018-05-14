package com.ding.webcollector_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = {"com.ding.webcollector_boot.dao"})
public class WebcollectorBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebcollectorBootApplication.class, args);
    }
}
