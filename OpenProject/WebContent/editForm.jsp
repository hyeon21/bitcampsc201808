<%@page import="jdbc.ConnectionProvider"%>
<%@page import="model.MemberInfo"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("userid");

	Connection conn = ConnectionProvider.getConnection();
	MemberDao memberDao = MemberDao.getInstance();
	MemberInfo memberInfo = memberDao.select(conn, userId);

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
		<form action="edit2.jsp?userid=<%=memberInfo.getUserId()%>" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="userId" value="<%=memberInfo.getUserId()%>" readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" value="<%=memberInfo.getPassword()%>"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName" value="<%=memberInfo.getUserName()%>"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photoFile" value="<%=memberInfo.getUserPhoto()%>"></td>
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