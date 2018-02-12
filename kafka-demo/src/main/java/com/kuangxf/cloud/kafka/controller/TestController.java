/*
 * @(#)TestController.java        1.0 2018年2月12日
 *
 *
 */

package com.kuangxf.cloud.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "kafka-demo")
@RestController
public class TestController {
	public static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private KafkaTemplate<String, String> template;

	@RequestMapping(value="/send",method= {RequestMethod.POST})
	@ApiOperation(value = "发送MQ消息", notes = "发送MQ消息") //
	@ApiImplicitParams({ @ApiImplicitParam(name = "topic", value = "主题", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "key", value = "键", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "data", value = "数据", required = true, dataType = "String")//
	})
	String send(String topic, String key, String data) {
		template.send(topic, key, data);
		return "success";
	}

	@KafkaListener(id = "t1", topics = "t1")
	public void listenT1(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
	}

	@KafkaListener(id = "t2", topics = "t2")
	public void listenT2(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
	}
}
