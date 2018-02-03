package com.kuangxf.cloud.dao.mapper;

import java.util.List;

import com.kuangxf.cloud.dao.common.Page;
import com.kuangxf.cloud.dao.domain.member.MemberInfo;
import com.kuangxf.cloud.dao.po.member.MemberInfoQueryPo;

/**
 * 会员资料信息SQL映射
 * 
 * @author yuyang
 * @version 2017-10-09
 */
public interface MemberInfoMapper {
	
	List<MemberInfo> select(MemberInfoQueryPo query, Page page);

	/*List<MemberInfo> select(MemberInfoQueryPo query);*/
	
	void deleteMember(Long memberId);
}