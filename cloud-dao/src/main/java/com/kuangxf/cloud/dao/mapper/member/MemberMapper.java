package com.kuangxf.cloud.dao.mapper.member;

import java.util.List;

import com.kuangxf.cloud.dao.common.Page;
import com.kuangxf.cloud.dao.domain.member.Member;

public interface MemberMapper {
	int deleteByPrimaryKey(Long memberId);

	int insert(Member record);

	int insertSelective(Member record);

	Member selectByPrimaryKey(Long memberId);

	List<Member> selectAll(Page page);

	int updateByPrimaryKeySelective(Member record);

	int updateByPrimaryKey(Member record);
}