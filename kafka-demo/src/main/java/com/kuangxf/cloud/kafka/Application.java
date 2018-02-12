/*
 * @(#)Application.java        1.0 2018年2月12日
 *
 *
 */

package com.kuangxf.cloud.kafka;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		logger.info("kafka-demo>>>>>>服务启动完成!");
	}

}
