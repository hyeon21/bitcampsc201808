<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 Cookie[] cookies = request.getCookies();
 
 for(int i=0; i<cookies.length; i++){
	 Cookie c = cookies[i];
	 
	 if(c.getName().equals("id")){
		 c = new Cookie("id", "hot");
		 response.addCookie(c);
	 }
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 쿠키값 변경</h1>

<a href="viewCookie.jsp">쿠키 확인</a>
</body>
</html>