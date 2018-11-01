package com.team.springsns.member.dao;

import com.team.springsns.model.MemberInfo;

public interface MemberDaoInterface {

	public MemberInfo getMemberInfo (String userId);
	public int insertMemberInfo(MemberInfo memberInfo);
	public void updateMemberInfo(MemberInfo memberInfo);
}
