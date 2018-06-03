package com.ding.webcollector_boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
public class LiveCralwerAspect {

    @Around(value = "execution(* com.ding.webcollector_boot.shedule.*.*(..))")
    public Object remarkTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch("liveCrawler");
        stopWatch.start("爬虫启动");
        String name = proceedingJoinPoint.getClass().getName();
        log.info("环绕切面启动,{}",name);
        Object proceed = proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info("crawlerTime,Aop{},name{}",stopWatch.shortSummary(),name);
        return  proceed;
    }

}
