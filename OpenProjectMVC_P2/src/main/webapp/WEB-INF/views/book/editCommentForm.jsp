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
	
	<h1> 댓글 </h1>
	<form method="post">
		아이디: <input type="text" name="userId" value="${loginInfo.userId }" readonly/> <br />
		<input type="hidden" name="userIdx" value="${loginInfo.idx}">
		댓글:<textarea name="comment" cols="30" row="3" ></textarea> <br />
		<input type="submit" value="댓글수정" />
	</form>
</body>
</html>