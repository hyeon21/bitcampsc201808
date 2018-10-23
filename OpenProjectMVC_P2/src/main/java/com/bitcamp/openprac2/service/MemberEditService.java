package com.bitcamp.openprac2.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMemberDao;
import com.bitcamp.openprac2.model.MemberInfo;

public class MemberEditService {

	@Autowired
	private JDBCTemplateMemberDao memberDao;

	@Transactional
	public void editMember(MemberInfo memberInfo, HttpServletRequest request) throws SQLException {

		// DB 저장용 파일 이름, 물리적 저장할때의 이름
		String imgName = "";


		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";

		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		if (!memberInfo.getPhotoFile().isEmpty()) {

			imgName = memberInfo.getUserId() + "_" + memberInfo.getPhotoFile().getOriginalFilename();

			// 물리적 저장
			try {
				memberInfo.getPhotoFile().transferTo(new File(dir, imgName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// DB에 저정할 이름 SET
			memberInfo.setUserPhoto(imgName);

		} else {
			memberInfo.setUserPhoto(request.getParameter("before"));
		}
			memberDao.update(memberInfo);
	}
}
