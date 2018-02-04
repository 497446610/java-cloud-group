package com.kuangxf.cloud.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kuangxf.cloud.api.member.IMemberControllerApi;
import com.kuangxf.cloud.biz.member.IMemberService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class MemberControllerApiImpl implements IMemberControllerApi {

	@Autowired
	IMemberService memberService;

	@Override
	public String sayHello(String name) {
		return memberService.sayHello(name);
	}

}
