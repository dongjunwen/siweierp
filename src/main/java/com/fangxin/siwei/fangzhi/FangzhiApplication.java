package com.fangxin.siwei.fangzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.fangxin.siwei.fangzhi.mapper")
public class FangzhiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FangzhiApplication.class, args);
	}
}
