package com.kuangxf.cloud.api.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="会员管理")
@RequestMapping("member")
public interface IMemberControllerApi {

	
	@ApiOperation(value = "说你好", notes = "hello world")
	@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String")
	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam("name") String name);

}
