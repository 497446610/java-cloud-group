package com.kuangxf.cloud.biz.member.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kuangxf.cloud.biz.BaseService;
import com.kuangxf.cloud.biz.beans.member.MemberInfoQuery;
import com.kuangxf.cloud.biz.common.PageResult;
import com.kuangxf.cloud.biz.common.ServiceException;
import com.kuangxf.cloud.biz.member.IMemberService;

@Service("memberService")
public class MemberServiceImpl extends BaseService implements IMemberService {

	private final static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Override
	public PageResult queryMember(MemberInfoQuery query) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(Long memberId) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public String sayHello(String name) throws ServiceException {
		return "hello " + name;
	}

	@Override
	public String cacheData() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
