package com.kuangxf.cloud.web.feign.member;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-biz")
@RequestMapping("member")
public interface IMemberApi {
	
	@RequestMapping(value="sayHello",method=RequestMethod.GET)
	public String sayHello(@RequestParam("name") String name);

}
