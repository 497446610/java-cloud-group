package com.kuangxf.cloud.controller.member;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuangxf.cloud.api.member.IMemberControllerApi;
import com.kuangxf.cloud.biz.beans.member.MemberInfoBean;
import com.kuangxf.cloud.biz.beans.member.MemberInfoQuery;
import com.kuangxf.cloud.biz.member.IMemberService;

@RestController
public class MemberControllerApiImpl implements IMemberControllerApi {
	private final static Logger logger = LoggerFactory.getLogger(MemberControllerApiImpl.class);

	@Autowired
	IMemberService memberService;

	@Override
	public String sayHello(String name) {
		return memberService.sayHello(name);
	}

	@Override
	public String addMember(@RequestBody MemberInfoBean memberInfo) {
		logger.info("memberId:{},memberName:{}", memberInfo.getMemberId(), memberInfo.getName());
		return memberInfo.toString();
	}

	@Override
	public List<MemberInfoBean> list(MemberInfoQuery query) {
		logger.info("查询条件{}", query);
		List<MemberInfoBean> result = new ArrayList<>();
		MemberInfoBean m1 = new MemberInfoBean();
		m1.setMemberId(1L);
		m1.setName("况小锋");
		result.add(m1);
		result.add(m1);
		return result;
	}
	
	

}
