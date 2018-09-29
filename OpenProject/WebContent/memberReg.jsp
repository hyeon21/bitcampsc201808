<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.open.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String userName = request.getParameter("userName");
	String userPhoto = request.getParameter("photoFile");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbcUrl = "jdbc:apache:commons:dbcp:test";
	
	int resultCnt = 0;
	
	try {
		// 2. 커넥션 풀에서 커넥션 가져오기
		conn = DriverManager.getConnection(jdbcUrl);

		// 3. PreparedStatement 객체 생성
		String sql = "insert into Member(IDX, USERID, PASSWORD, USERNAME, USERPHOTO, REGDATE) values(IDX.NEXTVAL,?,?,?,?,sysdate)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, password);
		pstmt.setString(3, userName);
		pstmt.setString(4, userPhoto);
		resultCnt = pstmt.executeUpdate();

	} finally {
		pstmt.close();
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
 h2, td{
 padding: 10px;
 }
 
 
</style>
</head>
<body>

<%@ include file="common/header.jsp" %>
<div id="contents">
		 <h2>회원가입 완료</h2>

    <hr>
        <table>
          <tr>
            <td>아이디(이메일)</td>
              <td><%= userId %></td>
            </tr>
            <tr>
            <td>비밀번호</td>
              <td><%= password %></td>
            </tr>
            <tr>
            <td>이름</td>
              <td><%= userName %></td>
            </tr>
            <tr>
            <td>사진</td>
            <td><img src="./images/<%= userPhoto %>"></td>
            </tr>
        </table>
	</div>
</body>
</html>