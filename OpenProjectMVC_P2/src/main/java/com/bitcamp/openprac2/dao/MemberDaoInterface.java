package com.bitcamp.openprac2.dao;

import com.bitcamp.openprac2.model.MemberInfo;

public interface MemberDaoInterface {

	public MemberInfo selectMember(String userId);
	public int insertMember(MemberInfo memberInfo);
	public void deleteMember(String userId);
}
