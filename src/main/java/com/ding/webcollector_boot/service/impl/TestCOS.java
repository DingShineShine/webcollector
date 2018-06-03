package com.ding.webcollector_boot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ding
 * @Description
 * @date 2018/06/03-21:15
 */
@Component
@Slf4j
public class TestCOS implements ServletContextListener {

    @Autowired
    private TestAdd testAdd;


    public Student testStudentAop (Integer a,Integer b){
        Student student = testAdd.testAddMethod(1, 2);
        return student;
    }


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.testStudentAop(1,2);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
