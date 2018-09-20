<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.open.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String beforeId = request.getParameter("beforeId");
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String userName = request.getParameter("userName");
	String userPhoto = request.getParameter("photoFile");

	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbcUrl = "jdbc:apache:commons:dbcp:test";

	int resultCnt = 0;

	try {
		// 2. (연결) 커넥션개체 생성
		conn = DriverManager.getConnection(jdbcUrl);

		// 3. PreparedStatement 객체 생성
		String sql = "update Member set userid=?, password=?, username=?, userphoto=? where userid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, password);
		pstmt.setString(3, userName);
		pstmt.setString(4, userPhoto);
		pstmt.setString(5, beforeId);
		resultCnt = pstmt.executeUpdate();

	} finally {
		pstmt.close();
		conn.close();
		response.sendRedirect("memberRegList.jsp");
	}
%>
