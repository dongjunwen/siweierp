package com.fangxin.siwei.fangzhi.config;

import net.bull.javamelody.MonitoringFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MelodyConfig {
    @Bean
    public FilterRegistrationBean MonitorFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MonitoringFilter());
        registration.addUrlPatterns("/*");
      //  registration.addInitParameter("paramName", "paramValue");
        registration.setName("monitor");
        registration.setOrder(1);
        return registration;
    }

}
