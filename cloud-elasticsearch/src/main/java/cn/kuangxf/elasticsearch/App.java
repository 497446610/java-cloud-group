package cn.kuangxf.elasticsearch;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "cn.kuangxf.elasticsearch.dao")  	
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
		logger.info("elasticsearch demo>>>>>>服务启动完成!");
		System.in.read();
	}

}
