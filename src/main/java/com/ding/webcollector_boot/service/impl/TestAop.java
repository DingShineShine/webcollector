package com.ding.webcollector_boot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import java.util.Arrays;

/**
 * @author ding
 * @Description
 * @date 2018/06/03-21:13
 */
@Component
@Aspect
@Slf4j
public class TestAop {

    @AfterThrowing(value = "execution(* com.ding.webcollector_boot.service.impl.TestCOS.*(..))"
    ,throwing = "ex")
    public void testThrowing(JoinPoint joinPoint, Throwable ex){
        Object[] args = joinPoint.getArgs();
        log.error("异常通知启动");
        Arrays.stream(args).forEach(x -> log.error(x.toString()));
        System.out.println("signature:"+joinPoint.getSignature());
        log.error("signature:"+joinPoint.getSignature());
        log.error("errorMessage:{}",ex.getMessage());
    }



}
