<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.open.Member"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	request.setCharacterEncoding("utf-8");
	
	List<Member> editMemberList = (List<Member>) application.getAttribute("members");

	int idx = Integer.parseInt(request.getParameter("idx"));
	
%>
<%

	String id = request.getParameter("userId");
	String pw = request.getParameter("password");
	String name = request.getParameter("userName");
	String photo = request.getParameter("photoFile");

	editMemberList.get(idx).setUserId(id);
	editMemberList.get(idx).setPassword(pw);
	editMemberList.get(idx).setUserName(name);
	editMemberList.get(idx).setUserPhoto(photo);
	
	application.setAttribute("members", editMemberList);

	response.sendRedirect("memberRegList.jsp");
	
	System.out.println(id);
	System.out.println(editMemberList.get(idx));
	
%>
