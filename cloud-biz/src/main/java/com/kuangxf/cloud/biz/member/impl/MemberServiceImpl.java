package com.kuangxf.cloud.biz.member.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kuangxf.cloud.biz.BaseService;
import com.kuangxf.cloud.biz.beans.member.MemberInfoBean;
import com.kuangxf.cloud.biz.beans.member.MemberInfoQuery;
import com.kuangxf.cloud.biz.common.PageResult;
import com.kuangxf.cloud.biz.common.ServiceException;
import com.kuangxf.cloud.biz.member.IMemberService;
import com.kuangxf.cloud.dao.common.Page;
import com.kuangxf.cloud.dao.domain.member.MemberInfo;
import com.kuangxf.cloud.dao.mapper.MemberInfoMapper;
import com.kuangxf.cloud.dao.po.member.MemberInfoQueryPo;

@Service("memberService")
public class MemberServiceImpl extends BaseService implements IMemberService {

	private final static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	MemberInfoMapper memberInfoMapper;

	@Override
	public PageResult queryMember(MemberInfoQuery query) throws ServiceException {

		Page page = query2Page(query);

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		logger.info("hello");
		List<MemberInfoBean> rows = null;
		try {

			MemberInfoQueryPo queryPo = new MemberInfoQueryPo();
			copyProperties(queryPo, query);
			List<MemberInfo> queryList = memberInfoMapper.select(queryPo, page);

			if (queryList == null || queryList.isEmpty()) {
				return emptyPageResult(page);
			}

			rows = new ArrayList<MemberInfoBean>(queryList.size());
			for (MemberInfo memberInfo : queryList) {
				MemberInfoBean memberInfoBean = new MemberInfoBean();
				copyProperties(memberInfoBean, memberInfo);
				rows.add(memberInfoBean);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException("查询会员信息失败！");
		}
		PageResult result = pageList2PageResult(rows, page);

		return result;
	}

	@Override
	public void deleteMember(Long memberId) throws ServiceException {

		if (memberId == null) {
			throw new ServiceException("会员ID不能为空！");
		}

		try {
			memberInfoMapper.deleteMember(memberId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException("删除会员信息失败！");
		}

	}

	@Override
	public String sayHello(String name) throws ServiceException {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(name);
		return " hello " + name + "," + new Date().toString();
	}

	@Override
	@Cacheable(cacheNames = "test")
	public String cacheData() throws ServiceException {

		return new Date().toString();
	}

}
