package com.gzxant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gzxant.constant.Setting;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(Setting.SCAN_MAPPER_PATH)//@Mapper  在mapper 接口上加入也行
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
