<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="com.open.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
	String userid = request.getParameter("userid");

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbcUrl = "jdbc:apache:commons:dbcp:test";
	
	int resultCnt = 0;

	try{
	// 커넥션 풀에서 커넥션 가져오기
	conn = DriverManager.getConnection(jdbcUrl);
	
	String sql = "delete from member where userid=?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,userid);
	resultCnt = pstmt.executeUpdate();
	} finally{
		pstmt.close();
		conn.close();
		// 멤버리스트로 리다이렉트
		response.sendRedirect("memberRegList.jsp");
	}

 %>  