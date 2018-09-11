<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 쿠키 객체 생성
	Cookie c = new Cookie("id", "cool");

	// reponse에 추가하기
	response.addCookie(c);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><%= c.getName() %> 쿠키의 값 = <%=c.getValue() %> 쿠키 저장 </h1>

<a href="viewCookie.jsp">쿠키 확인</a> <br>

<a href="editCookie.jsp">쿠키 변경</a>















</body>
</html>