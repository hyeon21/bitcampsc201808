<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2, td {
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div id="contents">
		<h2>로그인</h2>
		<hr>
		<form method="post"> <!-- 액션이 없으면 자기 자신에게 보낸다. -->
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="userId">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="rememberChk" >remember me!</td>
					<td><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>