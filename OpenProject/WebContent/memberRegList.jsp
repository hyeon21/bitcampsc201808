<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.open.Member"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
	
<%
	List<Member> memberList = (List<Member>)application.getAttribute("members");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
table {
	width: 80%;
	margin-top: 15px; border-collapse : collapse;
	text-align: center;
	border-collapse: collapse;
}

th, tr, td {
	border: 2px solid black;
	padding: 15px;
}

</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>

	<table>
	<tr>
		<th>아이디(이메일)</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>사진</th>
		<th>관리</th>
	</tr>
		<tbody id="tBody">
 <% if(memberList != null){ 
			for(int i=0; i<memberList.size(); i++){
		%>
		<tr>
			<td> <%=memberList.get(i).getUserId() %> </td>
			<td> <%=memberList.get(i).getPassword() %> </td>
			<td> <%=memberList.get(i).getUserName() %> </td>
			<td> <img src="images/<%=memberList.get(i).getUserPhoto() %>"> </td>
			<td><a href="edit.jsp?idx=<%=i%>">수정</a> <a href="delete.jsp?idx=<%=i%>">삭제</a></td>
		</tr>
		<% } 
		}%>
		</tbody>
	</table>
</body>
</html>