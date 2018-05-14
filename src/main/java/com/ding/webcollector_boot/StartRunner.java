package com.ding.webcollector_boot;

import com.ding.webcollector_boot.clawer.DouYuMagic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Ding
 * @create 2018/5/14
 * @description :
 */
@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    private DouYuMagic douYuMagic;

    @Override
    public void run(String... args) throws Exception {
        douYuMagic.run();
    }
}
