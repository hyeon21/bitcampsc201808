<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.open.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("userId");
	String pw = request.getParameter("password");
	
	String chkBox = request.getParameter("rememberChk");
	
	// System.out.println("remember me! 체크여부 : "+chkBox);
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String jdbcUrl = "jdbc:apache:commons:dbcp:test";
	
	int resultCnt = 0;
	
	try {
		// 2. (연결) 커넥션개체 생성
		conn = DriverManager.getConnection(jdbcUrl);

		// 3. Statement 객체 생성
		stmt = conn.createStatement();
		
		String sql = "select userid, password from member where userid='"+id+"'";
		rs = stmt.executeQuery(sql);

		if(rs.next()){
			if(pw.equals(rs.getString("password"))){
				request.getSession(false).setAttribute("userId", id); // 세션 생성하기
				
				if(chkBox==null){
					Cookie cookie = new Cookie("remember", "");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				} else {
					Cookie ck = new Cookie("remember", id);
					ck.setMaxAge(60*60*24*7);
					response.addCookie(ck);
				} 
				response.sendRedirect("index.jsp");
			}
		}
		
	} finally {
		stmt.close();
		conn.close();
	}

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
		<h2>로그인</h2>

		<hr>
		<h1>아이디 또는 비밀번호가 틀립니다. 확인해주세요.</h1>
		<h1>
			<a href="loginForm.jsp">다시 로그인하기</a>
		</h1>

	</div>
</body>
</html>