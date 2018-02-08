package com.kuangxf.cloud.web.feign.member;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuangxf.cloud.biz.beans.member.MemberBean;
import com.kuangxf.cloud.biz.beans.member.MemberQuery;
import com.kuangxf.cloud.biz.common.PageResult;

@FeignClient(value = "cloud-biz")
@RequestMapping("member")
public interface IMemberApi {

	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam("name") String name);

	@RequestMapping(value = "addMember", method = RequestMethod.POST, consumes = "application/json")
	public String addMember(@RequestBody MemberBean memberInfo);

	@RequestMapping(value = "list", method = RequestMethod.POST, consumes = "application/json")
	public PageResult<MemberBean> list(@RequestBody MemberQuery query);

}
