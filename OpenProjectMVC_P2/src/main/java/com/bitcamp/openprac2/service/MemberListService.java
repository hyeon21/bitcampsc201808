package com.bitcamp.openprac2.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMemberDao;
import com.bitcamp.openprac2.model.MemberInfo;

public class MemberListService {

	@Autowired
	private JDBCTemplateMemberDao memberDao;

	@Transactional
	public List<MemberInfo> getMemberList() throws SQLException {

		List<MemberInfo> memberList = memberDao.selectAll();
		System.out.println("멤버리스트 : "+memberList);
		return memberList;
	}
}
