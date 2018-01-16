package com.fangxin.siwei.fangzhi;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableAdminServer
@MapperScan("com.fangxin.siwei.fangzhi.mapper")
public class FangzhiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FangzhiApplication.class, args);
	}
}
