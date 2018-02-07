package com.kuangxf.cloud.dao.domain.member;

import java.util.Date;

/**
 * 会员信息 <br/>
 * table: member
 * @author kuangxf
 * @date 2018-02-07
 *
 */
public class Member {
    /**
     * 会员ID
     * 字段名 : member.member_id
     */
    private Long memberId;

    /**
     * 会员名称
     * 字段名 : member.member_name
     */
    private String memberName;

    /**
     * 性别
     * 字段名 : member.sex
     */
    private String sex;

    /**
     * 生日
     * 字段名 : member.birthday
     */
    private Date birthday;

    /**
     * 创建时间
     * 字段名 : member.create_time
     */
    private Date createTime;

    /**
     * 字段映射: member.member_id
     *
     * @return  会员ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 字段映射: member.member_id
     *
     * @param memberId  会员ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 字段映射: member.member_name
     *
     * @return  会员名称
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 字段映射: member.member_name
     *
     * @param memberName  会员名称
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 字段映射: member.sex
     *
     * @return  性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 字段映射: member.sex
     *
     * @param sex  性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 字段映射: member.birthday
     *
     * @return  生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 字段映射: member.birthday
     *
     * @param birthday  生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 字段映射: member.create_time
     *
     * @return  创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 字段映射: member.create_time
     *
     * @param createTime  创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", memberName=").append(memberName);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Member other = (Member) that;
        return (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getMemberName() == null ? other.getMemberName() == null : this.getMemberName().equals(other.getMemberName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMemberName() == null) ? 0 : getMemberName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}