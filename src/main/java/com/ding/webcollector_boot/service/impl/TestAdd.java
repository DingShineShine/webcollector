package com.ding.webcollector_boot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ding
 * @Description
 * @date 2018/06/03-22:14
 */
@Service
@Slf4j
public class TestAdd {

    public Student testAddMethod(Integer a,Integer b){
        Student xiaoming = new Student("xiaoming", 12);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
        try {

            xiaoming.setStudentAge(a+b);
        } catch (Exception e) {
            log.error("抓住一个做错");
        }
        return xiaoming;
    }
}
