package com.bitcamp.openprac2.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMemberDao;
import com.bitcamp.openprac2.model.MemberInfo;

public class MemberLoginService {

	/*@Autowired
	private MemberDao memberDao;
	*/
	
	@Autowired
	private JDBCTemplateMemberDao memberDao;
	
	@Transactional
	public boolean login(String userId, String pw, HttpSession session) throws SQLException {
		
		boolean result = false;
		
		MemberInfo memberInfo = memberDao.select(userId);
		
		// 멤버가 있고 패스워드가 일치하는지 확인
		if(memberInfo != null && (memberInfo.getPassword().equals(pw))) {
				// 로그인 처리 : 세션에 사용자 데이터 저장 
				memberInfo.setPassword("");
				
				session.setAttribute("loginInfo", memberInfo);
				
				result = true;
			}
		
		
		return result;
	}
}
