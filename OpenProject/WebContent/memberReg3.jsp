<%@page import="service.MemberRegService"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	MemberInfo memberInfo = new MemberInfo();

	//1. multipart/form-data 여부 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	if (isMultipart) {
		// 2. 메모리나 파일로 업로드 파일 보관하는 FileItem의 Factory 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 3. 업로드 요청을 처리하는 ServletFileUpload 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 4. 업로드 요청 파싱해서 FileItem 목록 구함
		List<FileItem> items = upload.parseRequest(request);

		Iterator<FileItem> itr = items.iterator();

		while (itr.hasNext()) {
	FileItem item = itr.next();

	// 5. FileItem이 폼 입력 항목인지 여부에 따라 알맞은 처리
	if (item.isFormField()) { // 텍스트 입력인 경우

		if (item.getFieldName().equals("userId")) {
	memberInfo.setUserId(item.getString("utf-8"));
		}

		if (item.getFieldName().equals("password")) {
	memberInfo.setPassword(item.getString("utf-8"));
		}

		if (item.getFieldName().equals("userName")) {
	memberInfo.setUserName(item.getString("utf-8"));
		}

	} else {

		if (item.getFieldName().equals("photoFile") && item.getSize() > 0 && item.getName() != null
		&& item.getName().length() > 0) {
	// 물리적인 파일의 저장
	// MemberInfo .setUserPhoto("물리적 파일의 이름") 로 저장

	// 저장하기 위한 파일의 새로운 이름 생성
	String newFileName = "";
	String fileName = item.getName();
	newFileName = System.currentTimeMillis() + "_" + fileName;

	String uploadUri = "/uploadFile";
	String dir = request.getSession().getServletContext().getRealPath(uploadUri);

	File file = new File(dir, newFileName);
	
	// 물리적인 저장
	item.write(file);
	
	memberInfo.setUserPhoto(newFileName);
	
	System.out.println(dir);

		}
	}
		}
	}
%>


<%
	MemberRegService regService = MemberRegService.getInstance();
	regService.reg(memberInfo);
	response.sendRedirect("index.jsp");

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
h2, td {
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="common/header.jsp"%>
	<div id="contents">
		<h2>회원가입 완료</h2>

		<hr>
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td><%= memberInfo.getUserId()%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%=memberInfo.getPassword()%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=memberInfo.getUserName()%></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><img src="<%= request.getContextPath()+"/uploadFile/"+memberInfo.getUserPhoto()%>"></td>
			</tr>
		</table>
	</div>
</body>
</html>