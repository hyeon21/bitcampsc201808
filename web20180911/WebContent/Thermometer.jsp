<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.Thermometer"%>
<%
	Thermometer t = new Thermometer();

	request.setAttribute("t", t);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	${t.setCelsius('서울',27.3)} 온도 설정 <br>
	
	서울 온도 : 섭씨 - ${t.getCelsius('서울')}
	
	<br>
	
	서울 온도 : 화씨 - ${t.getFahrenheit('서울')}
	
	<br>
	
	정보 : ${t.info}
	
</body>
</html>