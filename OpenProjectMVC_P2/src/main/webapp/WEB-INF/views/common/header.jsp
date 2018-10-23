<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bitcamp.openprac2.model.*" %>
	
<h1 class="title">Open Project</h1>
<ul id="gnb">
	<li><a href="/openprac2">메인</a></li>
	<li><a href="/openprac2/member/memberReg">회원가입</a></li>
	<%
	MemberInfo loginInfo = (MemberInfo)request.getSession(false).getAttribute("loginInfo");
	
	if(loginInfo == null){
	%>
	<li><a href="/openprac2/member/login">로그인</a></li>
	<% } else { %>
	<li><a href="/openprac2/member/logout">로그아웃</a></li>
	<% } %>
	<li><a href="/openprac2/member/myPage">마이페이지</a></li>
	<li><a href="/openprac2/member/memberList">회원리스트</a></li>
	<li><a href="/openprac2/book/bookList">방명록</a></li>
</ul>