package com.fangxin.siwei.fangzhi;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
@SpringBootApplication(
		exclude = { DataSourceAutoConfiguration.class }
)*/
@SpringBootApplication
@EnableAutoConfiguration
//@EnableAdminServer
@EnableTransactionManagement
@ComponentScan("com.fangxin.siwei.fangzhi")
public class FangzhiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FangzhiApplication.class, args);
	}
}
