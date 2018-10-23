package com.bitcamp.openprac2.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMemberDao;
import com.bitcamp.openprac2.model.MemberInfo;

public class MemberRegService {
	
	/*@Autowired
	private MemberDao memberDao;*/
	
	@Autowired
	private JDBCTemplateMemberDao memberDao;
	
	// private Connection conn;
	
	 @Transactional
	public int memberReg(MemberInfo memberInfo, HttpServletRequest request) throws SQLException, IllegalStateException, IOException{
		
		// conn = ConnectionProvider.getConnection();
		int resultCnt = 0;
		
		// DB 저장용 파일 이름, 물리적 저장할때의 이름
		String imgName = "";
		
		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";
		
		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
		
		if(!memberInfo.getPhotoFile().isEmpty()) {
			
			imgName = memberInfo.getUserId()+"_"+memberInfo.getPhotoFile().getOriginalFilename();
			
			// 물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));
			
			// DB에 저정할 이름 SET
			memberInfo.setUserPhoto(imgName);
			
			System.out.println(dir);
			
			System.out.println(memberInfo);
			
		}
		
		//try {
		//	conn.setAutoCommit(false);

			resultCnt = memberDao.insert(memberInfo);
			
			System.out.println("신규 회원의 인덱스 값 : " + memberInfo.getIdx());
			
		//	conn.commit();
		//}catch(Exception e){
		//	JdbcUtil.rollback(null);
		//	throw e;
		//}finally {
		//	conn.setAutoCommit(true);
		//	JdbcUtil.close(conn);
		//}
		return resultCnt;
	}
}
