<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 변수(article의 id)는 private 처리되어있어서 못가져옴. 여기 EL의 article.id는 get메서드를 호출하는것. -->
<!-- article 클래스의 getId() 메서드 호출 -->
<h1>${article.id }</h1>

</body>
</html>