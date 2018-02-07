package com.kuangxf.cloud.biz.beans.member;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员信息
 *
 */
@ApiModel(description = "会员信息")
public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1201474724664705406L;

	/**
	 * 会员ID<br/>
	 * 字段名 : member_id
	 */
	@ApiModelProperty(value = "会员ID")
	private Long memberId;

	/**
	 * 会员名称<br/>
	 * 字段名 : member_name
	 */
	@ApiModelProperty(value = "会员名称", required = true)
	private String memberName;

	/**
	 * 性别<br/>
	 * 字段名 : sex
	 */
	private String sex;

	/**
	 * 生日<br/>
	 * 字段名 : birthday
	 */
	private Date birthday;

	/**
	 * 创建时间<br/>
	 * 字段名 : create_time
	 */
	private Date createTime;

	/**
	 * 字段映射: member_id
	 *
	 * @return 会员ID
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * 字段映射: member_id
	 *
	 * @param memberId
	 *            会员ID
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	/**
	 * 字段映射: member_name
	 *
	 * @return 会员名称
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * 字段映射: member_name
	 *
	 * @param memberName
	 *            会员名称
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName == null ? null : memberName.trim();
	}

	/**
	 * 字段映射: sex
	 *
	 * @return 性别
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 字段映射: sex
	 *
	 * @param sex
	 *            性别
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	/**
	 * 字段映射: birthday
	 *
	 * @return 生日
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 字段映射: birthday
	 *
	 * @param birthday
	 *            生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 字段映射: create_time
	 *
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 字段映射: create_time
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "MemberBean [memberId=" + memberId + ", memberName=" + memberName + ", sex=" + sex + ", birthday="
				+ birthday + ", createTime=" + createTime + "]";
	}

}
