package com.kuangxf.cloud.web.controller.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuangxf.cloud.biz.beans.member.MemberBean;
import com.kuangxf.cloud.biz.beans.member.MemberQuery;
import com.kuangxf.cloud.biz.common.PageResult;
import com.kuangxf.cloud.web.beans.member.Demo;
import com.kuangxf.cloud.web.controller.AjaxResult;
import com.kuangxf.cloud.web.feign.member.IMemberApi;

@RestController
public class MemberController {
	//private final static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	IMemberApi memberApi;

	/**
	 * 数据验证demo
	 * 
	 * @param demo
	 * @param result
	 * @return
	 */
	@RequestMapping("valid")
	public AjaxResult valid(@Valid Demo demo, BindingResult bindResult) {
		if (bindResult.hasErrors()) {
			return AjaxResult.validfailed(bindResult.getAllErrors());
		}
		return AjaxResult.success("数据验证成功!");
	}

	@RequestMapping("hello")
	public AjaxResult hello(String name) {
		String result = memberApi.sayHello(name);
		return AjaxResult.success("调用服务成功!", result);
	}

	@RequestMapping("addMember")
	public AjaxResult addMember(String name) {
		MemberBean member = new MemberBean();
		member.setMemberId(1L);
		member.setMemberName(name);
		String result = memberApi.addMember(member);
		return AjaxResult.success("调用服务成功!", result);
	}
	
	
	@RequestMapping("listMember")
	public AjaxResult listMember(String name) {
		MemberQuery member = new MemberQuery();
		member.setName(name);
		PageResult<MemberBean> result = memberApi.list(member);
		return AjaxResult.success(result);
	}

}
