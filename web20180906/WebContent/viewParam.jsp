<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터를 utf-8형식으로 받아오기 위해서 써줌
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userName = request.getParameter("userName");
	String address = request.getParameter("address");
	

%>
	
	userName 파라미터 : <%= userName %> <br>
	address 파라미터 : <%= address %> <br>

	<hr>
<%
	String[] pets = request.getParameterValues("pet");

	if(pets != null){
		for(int i=0; i<pets.length; i++){
			%>
				<%= pets[i] %> <br>
			<%
		}
	}
%>

<hr>

<%
	Enumeration enumParam = request.getParameterNames();

	while(enumParam.hasMoreElements()){ // boolean 타입으로 반환.
		String name = (String)enumParam.nextElement(); // 다음 요소를 가져온다. Object 타입(모든타입)을 반환이라 형변환 필요
		%>
			<%= name %> <%= request.getParameter(name) %> <br>
		<%
		
	}
%>

<hr>

<%
	Map mapParam = request.getParameterMap();  // map은 <키String, 밸류String[]>
	
	String[] userNames = (String[])mapParam.get("userName");  // 얘도 오브젝트타입 반환이라 형변환 필요
	
	if(userNames != null){
		%>
			userName : <%= userNames[0] %>
		<%
	}
%>
</body>
</html>