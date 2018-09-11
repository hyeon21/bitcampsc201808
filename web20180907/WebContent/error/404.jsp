<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
요청하신 페이지는 존재하지 않습니다.
빠른 시간내에 처리하겠습니다.
<h3>에러 타입 : <%=exception.getClass().getSimpleName() %></h3>
<h3>에러 메세지 : <%=exception.getMessage() %></h3>
</body>
</html>