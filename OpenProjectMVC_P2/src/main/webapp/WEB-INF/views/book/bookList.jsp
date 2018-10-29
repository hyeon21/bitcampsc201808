<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Book</title>
<link rel="stylesheet" href="../css/default.css">
<style>
*{
text-decoration: none;
}
h1, h2, h3{
margin: 10px;
}
table{
	width: 1000px;
	border: 1px solid black;
}
td{
	border: 1px solid black;
	padding: 10px;
}
.center{
text-align: center;
}

</style>
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<h3><a href="writeMessage">메세지 남기기</a></h3>


	<c:if test="${viewData.isEmpty() }">
작성된 방명록 메세지가 없습니다.
	</c:if>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>게시글</th>
			<th>좋아요</th>
			<th>관리</th>
		</tr>

	<c:if test="${!viewData.isEmpty() }">
			<c:forEach var="message" items="${viewData.messageList}">
			<tr>
				<td class="center" width=50>${message.messageId}</td>
				<td width=60>${message.userId}</td>
				<td>${message.message}</td>
				<td class="center" width=50>
					<c:forEach var="like" items="${countList}">
						<c:if test="${like.messageId eq message.messageId}">
							${like.likeCnt}
						</c:if>
					</c:forEach>
				</td>
				<td class="center" width=320>
					<a href="likeMessage?messageId=${message.messageId}&userIdx=${loginInfo.idx}">[좋아요]</a>
					<a href="messageDetailView/${message.messageId}">[상세보기]</a>
					
					<c:if test="${loginInfo.userId eq message.userId or loginInfo.userId eq 'hyeon21'}">
					<a href="deleteMessage?id=${message.messageId}">[삭제하기]</a>
					</c:if>
					
					<a href="comment?messageId=${message.messageId}">[댓글달기]</a>
					</td>
					</c:forEach>
			</c:if>
		</table>
		
		
		<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
			<a href="bookList?page=${num}">[${num}]</a>
		
		</c:forEach>
		

</body>
</html> --%>