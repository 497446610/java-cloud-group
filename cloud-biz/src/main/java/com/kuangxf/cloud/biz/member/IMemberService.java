package com.kuangxf.cloud.biz.member;

import org.springframework.stereotype.Service;

import com.kuangxf.cloud.biz.beans.member.MemberInfoQuery;
import com.kuangxf.cloud.biz.common.PageResult;
import com.kuangxf.cloud.biz.common.ServiceException;

/**
 * 会员业务接口
 * 
 *
 */
@Service
public interface IMemberService {

	/**
	 * 查询会员业务接口
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public PageResult queryMember(MemberInfoQuery query) throws ServiceException;

	/**
	 * 逻辑删除会员
	 * 
	 * @param memberId
	 *            会员ID(必传)
	 * @throws ServiceException
	 */
	public void deleteMember(Long memberId) throws ServiceException;

	/**
	 * 测试接口
	 * 
	 * @param name
	 * @return
	 * @throws ServiceException
	 */
	public String sayHello(String name) throws ServiceException;

	/**
	 * 数据缓存测试接口
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public String cacheData() throws ServiceException;

}
