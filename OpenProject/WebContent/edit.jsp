<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.open.Member"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	request.setCharacterEncoding("utf-8");
	
	List<Member> memberList = (List<Member>) application.getAttribute("members");
	// 인덱스
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	request.setCharacterEncoding("utf-8");

	// 멤버리스트(인덱스).getUserId();
	String id = memberList.get(idx).getUserId();
	String pw = memberList.get(idx).getPassword();
	String name = memberList.get(idx).getUserName();
	String photo = memberList.get(idx).getUserPhoto();
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
		<form action="regEdit.jsp?idx=<%=idx %>" method="post">
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