<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String empno = request.getParameter("empno");

	// Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection conn = null;
	PreparedStatement pstmt = null;

	/* String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "0221"; */
	
	String jdbcUrl = "jdbc:apache:commons:dbcp:open";
	
	int resultCnt = 0;

	try{
	// 커넥션 풀에서 커넥션을 구함
	conn = DriverManager.getConnection(jdbcUrl);
	
	String sql = "delete from emp where empno=?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, Integer.parseInt(empno));
	resultCnt = pstmt.executeUpdate();
	} finally{
		pstmt.close();
		// 커넥션 반환
		conn.close();
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 삭제 완료 <%=resultCnt %> <a href="emp_list.jsp">emp LIST</a></h1>
</body>
</html>