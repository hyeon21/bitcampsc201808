<%@page import="service.EditMemberService"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("userid");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id = "";
	String pw = "";
	String name = "";
	String photo = "";

	String jdbcUrl = "jdbc:apache:commons:dbcp:test";

	try {
	// 2. (연결) 커넥션개체 생성
	// conn = DriverManager.getConnection(url, user, password);
	// 커넥션 풀을 이용한다.
	conn = DriverManager.getConnection(jdbcUrl);

	// 3. Statement 객체 생성
	stmt = conn.createStatement();

	String list_sql = "select userid, password, username, userphoto from member where userid='" + uid + "'";

	// 4. 쿼리 실행
	rs = stmt.executeQuery(list_sql);

		if (rs.next()) {
			id = rs.getString("userid");
			pw = rs.getString("password");
			name = rs.getString("username");
			photo = rs.getString("userphoto");
		} 
	}finally {
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
		<h2>회원정보 수정</h2>

		<hr>
		<form action="edit.jsp?beforeId=<%=id%>" method="post">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="userId" value="<%=id%>"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" value="<%=pw%>"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName" value="<%=name%>"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photoFile" value="<%=photo%>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>