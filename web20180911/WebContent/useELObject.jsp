<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("id", "cool"); // id란 이름의 속성과 값
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	기본객체 사용 : <br>
	요청 URI : ${pageContext.request.requestURI}
	
	<hr>
	
	request 속성 확인 id : ${requestScope.id} <br>
	
	<hr>
	
	파라미터 확인 code : ${param.code} <!-- EL은 값이 null인 경우 공백으로 표현된다 -->
</body>
</html>