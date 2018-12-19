<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>구매완료</h1>
	<h3>아이템 목록</h3>
	
	<ul>
	<c:forEach var="item" items="${orderCommand.orderItems}"> <!-- items는 원본. orderItems에서 get 생략-->
		<li>${item.itemId} / ${item.number} / ${item.remark}</li>
	</c:forEach>
	
	<h3>배송지</h3>
	${orderCommand.address}
	 
	</ul>
	
<!-- 사용자의 데이터 받기
	1. 컨트롤러의 메서드의 매개변수에 리퀘스트 객체를 등록 ( HttpServletRequest )하고 getParameter("");로.
	2. 애너테이션. @RequestParam(""). 리콰이어드 설정(값이 필수인지). 디폴트설정(값이 안들어왔을때 디폴트값 줄건지)
	3. 커맨드객체 - 많은 데이터를 한번에 받아서 처리할 수 있다.
	
	2번과 3번을 주로 사용하게될것.  

 -->
</body>
</html>