<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Book</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<a href="writeMessage">메세지 남기기</a>
	<br>
	<br>

	<c:if test="${viewData.isEmpty() }">
작성된 방명록 메세지가 없습니다.
	</c:if>

	<c:if test="${!viewData.isEmpty() }">
		<ul>
			<c:forEach var="message" items="${viewData.messageList}">
				<li>글번호 : ${message.messageId}<br>
					작성자 : ${message.userId} <br>
					글내용 : ${message.message} <br>
					<a href="messageDetailView/${message.messageId}">상세보기</a>
					
					<c:if test="${loginInfo.userId eq message.userId or loginInfo.userId eq 'hyeon21'}">
					<a href="deleteMessage?id=${message.messageId}">[삭제하기]</a>
					</c:if>
					<br>
					
				</li>
			</c:forEach>
		</ul>
		
		<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
			<a href="bookList?page=${num}">[${num}]</a>
		
		</c:forEach>
		
	</c:if>

</body>
</html>