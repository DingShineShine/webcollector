package com.ding.webcollector_boot.dao;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 连接池配置,可通过localhost:8080/druid 直接访问
 * 账号密码在代码里
 */
@Configuration
public class DruidConfig {

    /**
     * 注册一个StatViewServlet
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServle2() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        //添加初始化参数：initParams
        /** 白名单，如果不配置或value为空，则允许所有 */
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        /** 黑名单，与白名单存在相同IP时，优先于白名单 */
//        servletRegistrationBean.addInitParameter("deny","192.0.0.1");
        /** 用户名 */
        servletRegistrationBean.addInitParameter("loginUsername", "ding");
        /** 密码 */
        servletRegistrationBean.addInitParameter("loginPassword", "asdwsx");
        /** 禁用页面上的“Reset All”功能 */
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册一个：WebStatFilter
     *
     */
    @Bean
    public FilterRegistrationBean druidStatFilter2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        /** 过滤规则 */
        filterRegistrationBean.addUrlPatterns("/*");
        /** 忽略资源 */
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}