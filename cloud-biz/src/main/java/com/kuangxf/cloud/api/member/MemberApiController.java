package com.kuangxf.cloud.api.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuangxf.cloud.biz.member.IMemberService;

@RestController
@RequestMapping("member")
public class MemberApiController implements IMemberApi {

	@Autowired
	IMemberService memberService;

	@Override
	@RequestMapping("sayHello")
	public String sayHello(String name) {
		return memberService.sayHello(name);
	}

}
