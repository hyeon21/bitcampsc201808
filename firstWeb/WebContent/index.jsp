<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces= "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP -1</title>
<style>
body{
text-align: center;
}

h1{
margin-top: 50px;
}

div
</style>
</head>
<body>
<h1>include 지시어 테스트</h1>
<hr>
<%@ include file="includeTest1.jsp" %>
<div>
<%@ include file="includeTest2.jsp" %>
<%@ include file="includeTest3.jsp" %>
</div>
</body>
</html>