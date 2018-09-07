<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("userId");
	String pw = request.getParameter("password");
	
	if(id != null && pw != null && id.equals(pw)){
		request.getSession(false).setAttribute("userId", id); // (키, 밸류)
		request.getSession(false).setAttribute("userName", "홍길동"); // 홍길동은 임의의 값
		response.sendRedirect("myPage.jsp"); // 리다이렉트
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
		<h2>로그인</h2>
		
		<hr>
		<h1>아이디 또는 비밀번호가 틀립니다. 확인해주세요.</h1>
		<h1><a href="loginForm.jsp">다시 로그인하기</a></h1>
		
	</div>
</body>
</html>