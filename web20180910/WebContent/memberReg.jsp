<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="member.MemberInfo"/>
<jsp:setProperty property="*" name="member"/>
<jsp:setProperty property="password" name="member.getId()"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입 정보</h1>
	<table>
			<tr>
				<td>아이디</td>
				<td><%=member.getId()%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=member.getName()%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%=member.getId()%></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=member.getEmail()%></td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
			<tr>
				<td>이메일</td>
				<td><%=member.getAddress()%></td>
			</tr>

		</table>
</body>
</html>