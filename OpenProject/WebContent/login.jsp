<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.open.Member"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("userId");
	String pw = request.getParameter("password");
	String name = request.getParameter("userName");

	List<Member> idPwChk = (List<Member>) application.getAttribute("members");

	/* 	if (application.getAttribute("members") != null) {
			idPwChk = (List<Member>) application.getAttribute("members");
		} else {
			idPwChk = new ArrayList<Member>();
		} */
%>

<%
	/* 	if(id != null && pw != null && id.equals(pw)){
			request.getSession(false).setAttribute("userId", id); // (키, 밸류)
			request.getSession(false).setAttribute("userName", "홍길동"); // 홍길동은 임의의 값
			response.sendRedirect("index.jsp"); // 리다이렉트 */
	if (idPwChk != null) {
		for (int i = 0; i < idPwChk.size(); i++) {
			if (id.equals(idPwChk.get(i).getUserId())) { // 아이디가 어플리케이션에 있는가? 비밀번호가 일치하는가?
				if (pw.equals(idPwChk.get(i).getPassword())) {
					request.getSession(false).setAttribute("userId", id);
					request.getSession(false).setAttribute("userName", name);
					response.sendRedirect("index.jsp");
				}
			}
		}
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