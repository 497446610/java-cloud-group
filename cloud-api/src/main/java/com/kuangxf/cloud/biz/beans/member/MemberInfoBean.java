package com.kuangxf.cloud.biz.beans.member;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员信息
 *
 */
@ApiModel(description = "会员信息")
public class MemberInfoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1201474724664705406L;

	/**
	 * 会员ID
	 */
	@ApiModelProperty(value = "会员ID")
	private Long memberId;

	/**
	 * 会员名称
	 */
	@ApiModelProperty(value = "会员名称", required = true)
	private String name;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberInfoBean [memberId=" + memberId + ", name=" + name + "]";
	}
	
	

}
