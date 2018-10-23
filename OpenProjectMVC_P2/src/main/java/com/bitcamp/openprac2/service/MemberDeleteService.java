package com.bitcamp.openprac2.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMemberDao;

// 2018.10.01 회원정보 삭제 서비스패턴 구현
public class MemberDeleteService {

	@Autowired
	private JDBCTemplateMemberDao memberDao;

	@Transactional
	public void deleteMember(String userId) throws SQLException {
		System.out.println("삭제서비스 메서드 진입");
		memberDao.delete(userId);

	}
}
