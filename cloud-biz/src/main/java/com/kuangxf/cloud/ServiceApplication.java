package com.kuangxf.cloud;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.kuangxf.cloud.dao.mapper")
@ComponentScan(basePackages="com.kuangxf.cloud")
@EnableCaching
@EnableTransactionManagement
public class ServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

	public static void main(String[] args) throws IOException{
		SpringApplication.run(ServiceApplication.class, args);
		logger.info("service-provider>>>>>>服务启动完成!");
		System.in.read();
	}



}
