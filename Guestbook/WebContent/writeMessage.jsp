<%@page import="guest.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 잊지말자!
%>
<jsp:useBean id="message" class="guest.model.Message">
	<jsp:setProperty name="message" property="*" />
</jsp:useBean>
<%
	WriteMessageService writeService = WriteMessageService.getInstance();
	writeService.write(message);
	response.sendRedirect("list.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>