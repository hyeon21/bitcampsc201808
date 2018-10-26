package com.bitcamp.openprac2.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.MemberDaoInterface;
import com.bitcamp.openprac2.dao.MybatisMemberDao;
import com.bitcamp.openprac2.model.MemberInfo;

public class MemberLoginService {

	/*@Autowired
	private MemberDao memberDao;
	*/
	
	/*@Autowired
	private JDBCTemplateMemberDao memberDao;*/

	/*@Autowired
	private MybatisMemberDao memberDao;*/
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDaoInterface memberDao;
	
	
	@Transactional
	public boolean login(String userId, String pw, HttpSession session) throws SQLException {
		
		boolean result = false;
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		
		MemberInfo memberInfo = memberDao.selectMember(userId);
		
		// 멤버가 있고 패스워드가 일치하는지 확인
		if(memberInfo != null && (memberInfo.getPassword().equals(pw))) {
				// 로그인 처리 : 세션에 사용자 데이터 저장 
				// 보안을 위해서 패스워드를 비워준다.
				memberInfo.setPassword("");
				
				session.setAttribute("loginInfo", memberInfo);
				System.out.println("로그인한 멤버의 인덱스 : "+memberInfo.getIdx());
				
				result = true;
			}
		
		
		return result;
	}
}
