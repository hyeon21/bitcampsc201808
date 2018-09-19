<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.open.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

 <%
	List<Member> modMemberList = (List<Member>)application.getAttribute("members");
	
	// id가 일치하는 멤버객체의 인덱스가 필요
	int index = Integer.parseInt(request.getParameter("idx"));
	// 해당하는 id의 객체를 지우고
	modMemberList.remove(index);
	// 다시 어플리케이션 멤버스에 저장하기
	application.setAttribute("members", modMemberList);
	
	// 멤버리스트로 리다이렉트!
	response.sendRedirect("memberRegList.jsp");
	
 %>  