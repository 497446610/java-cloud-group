package com.kuangxf.cloud.biz.member.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuangxf.cloud.biz.BaseService;
import com.kuangxf.cloud.biz.beans.member.MemberQuery;
import com.kuangxf.cloud.biz.common.PageResult;
import com.kuangxf.cloud.biz.common.ServiceException;
import com.kuangxf.cloud.biz.member.IMemberService;
import com.kuangxf.cloud.dao.common.Page;
import com.kuangxf.cloud.dao.domain.member.Member;
import com.kuangxf.cloud.dao.mapper.member.MemberMapper;

@Service("memberService")
public class MemberServiceImpl extends BaseService implements IMemberService {

	private final static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public PageResult queryMember(MemberQuery query) throws ServiceException {
		Page page = query2Page(query);
		List<Member> list = memberMapper.selectAll(page);
		return pageList2PageResult(list,page);
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
