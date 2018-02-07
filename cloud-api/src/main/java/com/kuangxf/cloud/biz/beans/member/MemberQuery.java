package com.kuangxf.cloud.biz.beans.member;

import java.io.Serializable;

import com.kuangxf.cloud.biz.common.PageParam;

/**
 * 会员信息查询条件
 *
 */
public class MemberQuery extends PageParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4487419333750850126L;

	/**
	 * 会员名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberQuery [name=" + name + "]";
	}

	
}
