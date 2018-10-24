<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>

td{
padding: 5px 20px;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h1>회원리스트</h1>

	<c:if test="${memberList.isEmpty() }">
회원이 없습니다.
</c:if>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>아이디(이메일)</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>사진</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>

		<c:if test="${!memberList.isEmpty() }">
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td>${member.idx }</td>
					<td>${member.userId }</td>
					<td>${member.password }</td>
					<td>${member.userName }</td>
					<td><img src="<%= request.getContextPath()%>/uploadfile/userphoto/${member.userPhoto }"></td>
					<td>${member.regdate }</td>
					
					<c:if test="${(loginInfo.userId eq member.userId) or (loginInfo.userId eq 'hyeon21')}">
					<td><a href="memberEdit?userId=${member.userId }">수정</a> / <a href="memberDelete?userId=${member.userId }">삭제</a></td>
					</c:if>
					
					<c:if test="${!(loginInfo.userId eq member.userId) and !(loginInfo.userId eq 'hyeon21')}">
					<td>수정 /삭제</td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>

	</table>

</body>
</html>