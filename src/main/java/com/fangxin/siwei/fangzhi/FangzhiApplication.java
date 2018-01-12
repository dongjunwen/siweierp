package com.fangxin.siwei.fangzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.fangxin.siwei.fangzhi.mapper")
public class FangzhiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FangzhiApplication.class, args);
	}
}
