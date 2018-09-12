<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>날짜 포맷</h1>
	
	<!-- 표현식은 권장하지 않지만 일단쓴다 -->
	<c:set var="now" value="<%= new java.util.Date() %>"/>
	
	<fmt:formatDate value="${now}" type="date" dateStyle="full" /><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="short" /><br>
	<br>

	<fmt:formatDate value="${now}" type="time" timeStyle="full" /><br>
	<fmt:formatDate value="${now}" type="time" timeStyle="short" /><br>
	<br>

	<!-- 홍콩시간  -->
	<fmt:timeZone value="Hongkong">
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
	</fmt:timeZone>
	<br><br>
	
	<!-- z:위치 a:오전오후 h:mm 시간 -->
	<fmt:formatDate value="${now}" pattern="z a h:mm" /><br>
	<!-- 월의 경우는 대문자로 해줘야한다 -->
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /><br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd" /><br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd. h:mm" /><br>
	<!-- 강사님 최고 -->
	<fmt:formatDate value="${now}" pattern="yyyy/MM/dd h:mm" /><br>
	


	<hr>
	<h1>숫자 포맷</h1>
	<c:set var="price" value="100000" />
	<!-- 세션이 유지되는 동안 numberType을 쓸 수 있다. -->
	<!-- var 정의 안하면 바로 출력, 정의하면 출력X 변수에 담아 쓸수 있다. -->
	<fmt:formatNumber value="${price }" type="number" var="numberType" scope="session"/>
	
	numberType : ${numberType}
	
	<br>
	
	통화 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="$"/>
	
	<br>
	
	퍼센트 : <fmt:formatNumber value="${price/1000000}" type="percent" groupingUsed="false"/>
	
	<br>
	
	패턴 : <fmt:formatNumber value="${price/1000000}" pattern="0,000,000,000.00"/>
</body>
</html>