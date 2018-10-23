<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2, td {
	padding: 10px;
}

#memberPhoto {
	background-image: url('<%=request.getContextPath()%>/uploadfile/userphoto/${loginInfo.userPhoto}');
	background-size: 150px;
	background-repeat: no-repeat;
	width: 150px;
	height: 150px;
	border: 1px solid #333333;
	border-radius: 75px;
	margin: 20px 0;
	
}

</style>
</head>
<body>

	<%@ include file="../common/header.jsp"%>
	<div id="contents">
		<h2>회원 정보</h2>

		<div id="memberPhoto">
			<%-- <img src="<%= request.getContextPath()+"/uploadFile/"+ photo%>"> --%>
		</div>

		<hr>
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td>${loginInfo.userId }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${loginInfo.userName }</td>
			</tr>
		</table>
	</div>
</body>
</html>