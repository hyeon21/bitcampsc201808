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

	<c:set var="price" value="100000" />
	<!-- 세션이 유지되는 동안 numberType을 쓸 수 있다. -->
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