package com.ding.webcollector_boot;

import com.ding.webcollector_boot.clawer.DouYuMagic;
import com.ding.webcollector_boot.clawer.XiongMaoMagic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Ding
 * @create 2018/5/14
 * @description : 测试使用,启动项目则启动爬虫
 */
@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    private DouYuMagic douYuMagic;

    @Autowired
    private XiongMaoMagic xiongMaoMagic;

    @Override
    public void run(String... args) throws Exception {
//        douYuMagic.run();
//        xiongMaoMagic.run();
    }
}
