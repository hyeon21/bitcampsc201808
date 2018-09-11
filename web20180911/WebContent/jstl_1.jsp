<%@page import="test.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<String> members = new ArrayList<String>();
	members.add("홍길동1");
	members.add("철수2");
	members.add("영희3");
	members.add("홍길동4");
	members.add("철수5");
	members.add("영희6");
	members.add("홍길동7");
	members.add("철수8");
	members.add("영희9");

	request.setAttribute("members", members);
%>
<%
	Member member = new Member();

	member.setName("김혜연");
	member.setEmail("runngun21@naver.com");

	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <c:redirect url="/useELObject.jsp">
<c:param name="code">1111</c:param>
</c:redirect> --%>

	<hr>

	<c:url value="/jstl_1.jsp" var="target">
		<c:param name="sel">c</c:param>
	</c:url>
	경로 : ${target }
	<br>
	<a href="${target }">c 페이지</a>

	<hr>

	<ul>
		<c:forEach items="${members}" var="mem" begin="0" end="5" varStatus="status">
			<li>${status.index} - ${status.count} - ${mem}</li>
		</c:forEach>
	</ul>

	<table border=1>
	<tr>
	<th>이름</th><th>전화번호</th><th>이메일</th><th>거주지</th>
	</tr>
		<tr>
			<c:forTokens var="sel" items="홍길동|010-9999-7777|test@test.com|서울" delims="|">
				<td>${sel}</td>
			</c:forTokens>

		</tr>
	</table>

	<hr>
	<h3>
		<c:choose>
			<c:when test="${param.sel == 'a'}">
			a를 선택
		</c:when>
			<c:when test="${param.sel == 'b'}">
		b를 선택
		</c:when>
			<c:when test="${param.sel == 'c'}">
			c를 선택
		</c:when>
			<c:otherwise>
			a, b, c 이외의 선택
		</c:otherwise>
		</c:choose>
	</h3>

	<select>
		<option ${param.sel == 'a' ? 'selected' : ''}>a</option>
		<option ${param.sel == 'b' ? 'selected' : ''}>b</option>
		<option ${param.sel == 'c' ? 'selected' : ''}>c</option>
	</select>

	<hr>
	
	<c:set var="str" value="java" />
	msg : ${str} <br>
	<c:if test="${true}" var="result">
		참입니다.
	</c:if>
	
	<br>

	<c:if test="${str == 'java'}" var="result">
	Test Result : ${result}
	</c:if>

	<c:set var="msg" value="JAVA" />
	msg : ${msg} <br>
	msg : <%=pageContext.getAttribute("msg")%> <br>

	<c:set target="${member}" property="email" value="test@test.com" />

	Member name : ${member.name} <br>
	Member email : ${member.email} <br>

	<hr>

	<table border=1>

		<c:forEach var="name" items="${members}">

			<tr>
				<td><c:out value="${name}" escapeXml="false">

						<span style="color: red;">이름없음.</span>

					</c:out></td>
			</tr>


		</c:forEach>
	</table>

</body>
</html>