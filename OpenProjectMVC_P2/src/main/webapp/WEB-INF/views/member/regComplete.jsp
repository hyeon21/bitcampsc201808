<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 완료!</h1>

<h3>ID : ${memberInfo.userId}</h3>
<h3>Name : ${memberInfo.userName}</h3>

<h2>${memberInfo.userName }님 환영합니다!</h2>

<h4><a href="../">홈으로 돌아가기</a></h4>
</body>
</html>