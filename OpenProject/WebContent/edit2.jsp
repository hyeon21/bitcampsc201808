<%@page import="jdbc.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="service.EditMemberService"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("userid");
	
	Connection conn = ConnectionProvider.getConnection();
	
	MemberDao memberDao = MemberDao.getInstance();
	EditMemberService editService = EditMemberService.getInstance();
	MemberInfo memberInfo = memberDao.select(conn, userId);
	
%>
<%

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
editService.editMember(memberInfo);

response.sendRedirect("memberRegList.jsp");

%>

