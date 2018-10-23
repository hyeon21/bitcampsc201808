<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	
	<h1> 방명록 </h1>
	<form method="post">
		이름: <input type="text" name="userId" value="${loginInfo.userId }" readonly/> <br />
		메시지:<textarea name="message" cols="30" row="3" ></textarea> <br />
		<input type="submit" value="메시지 남기기" />
	</form>
</body>
</html>