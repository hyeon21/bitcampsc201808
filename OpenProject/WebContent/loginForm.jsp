<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//쿠키를 받아오기
	Cookie[] cookies = request.getCookies();

	String check = "";
	String idChk = "";
	
	//쿠키를 받아와서 id와 일치하는 쿠키를 로그인폼에 띄운다
	for(int i=0; i<cookies.length; i++){
		String ccc = cookies[i].getName();
		if(ccc.equals("remember")){
			check = "checked";
			idChk = cookies[i].getValue();
		}
		
		
	}

	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
h2, td {
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="common/header.jsp"%>

	<div id="contents">
		<h2>로그인</h2>
		<hr>
		<form action="login.jsp" method="post">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="userId" value=<%=idChk %>>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="rememberChk" <%=check %>>remember me!</td>
					<td><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>