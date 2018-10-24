package com.bitcamp.openprac2.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMemberDao;
import com.bitcamp.openprac2.dao.MemberDaoInterface;

// 2018.10.01 회원정보 삭제 서비스패턴 구현
public class MemberDeleteService {

	/*@Autowired
	private JDBCTemplateMemberDao memberDao;*/

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private MemberDaoInterface memberDao;
	
	
	@Transactional
	public void deleteMember(String userId) throws SQLException {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		memberDao.deleteMember(userId);

	}
}
