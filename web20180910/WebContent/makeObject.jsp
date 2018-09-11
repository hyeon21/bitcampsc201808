<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="member.MemberInfo" scope="request"/>
<%
   member.setId("me");
   member.setName("김혜연");
%>
<jsp:forward page="useObject.jsp" />