<%@page import="service.DeleteMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String userId = request.getParameter("userid");

	DeleteMemberService deleteService = DeleteMemberService.getInstance();
	deleteService.deleteMember(userId);
	response.sendRedirect("memberRegList.jsp");
%>