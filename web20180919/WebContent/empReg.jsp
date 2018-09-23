<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	String job = request.getParameter("job");

	// Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection conn = null;
	PreparedStatement pstmt = null;

	/* String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "0221"; */
	
	String jdbcUrl = "jdbc:apache:commons:dbcp:open";
	
	int resultCnt = 0;

	try {
		// 커넥션 풀에서 커넥션 가져오기
		conn = DriverManager.getConnection(jdbcUrl);

		// 3. PreparedStatement 객체 생성
		String sql = "insert into emp(empno, ename, job) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(empno)); // set메소드로 값을 입력
		pstmt.setString(2, ename);
		pstmt.setString(3, job); // empno를 겟파라미터로 받아올때 스트링타입으로 받아왔으니 인티저로 변환필요
		resultCnt = pstmt.executeUpdate();

	} finally {
		pstmt.close();
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
<h1>사원 등록 완료</h1>
<h2><a href="emp_list.jsp">리스트로 돌아가기</a></h2>
</body>
</html>