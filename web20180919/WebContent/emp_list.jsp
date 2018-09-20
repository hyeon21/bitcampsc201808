<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EMP LIST</title>
<style>
td{
width: 100px;
height: 30px;
text-align: center;
}
</style>
</head>
<body>
<h1>사원리스트</h1>
<h3><a href="empRegForm.jsp">사원 등록</a></h3>
	<table border="1">
		<tr>
			<td>사원번호</td>
			<td>사원이름</td>
			<td>직급</td>
			<td>관리</td>
		</tr>
		<%
			// 1. 데이터베이스 드라이버 로드 - 서블릿처리했음
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			// String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// String user = "scott";
			// String password = "0221";
			// 커넥션 풀을 이용한다.
			String jdbcUrl = "jdbc:apache:commons:dbcp:open";

			try {
				// 2. (연결) 커넥션개체 생성
				// conn = DriverManager.getConnection(url, user, password);
				// 커넥션 풀을 이용한다.
				conn = DriverManager.getConnection(jdbcUrl);
				
				// 3. Statement 객체 생성
				stmt = conn.createStatement();

				String list_sql = "select empno, ename, job from emp order by empno";

				// 4. 쿼리 실행
				rs = stmt.executeQuery(list_sql);

				if (rs.next()) {
					do {
		%>

		<tr>
			<td><%=rs.getInt("empno")%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString("job")%></td>
			<td><a href="editForm.jsp?empno=<%=rs.getInt("empno")%>">수정</a>
				<a href="delete.jsp?empno=<%=rs.getInt("empno")%>">삭제</a></td> 
		</tr>
		<%
			} while (rs.next());
				} else {
		%>

		<tr>
			<td colspan="3">등록된 사원정보가 없습니다.</td>
		</tr>

		<%
			}
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
					}
					if (stmt != null) {
						try {
							stmt.close();
						} catch (SQLException se) {
						}
					}

					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException se) {

						}
					}
				}
			}
		%>

	</table>



</body>
</html>