<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.open.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
table {
	width: 80%;
	margin-top: 15px;
	border-collapse: collapse;
	text-align: center;
	border-collapse: collapse;
}

th, tr, td {
	border: 2px solid black;
	padding: 15px;
}
</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>

	<table>
		<tr>
			<th>회원번호</th>
			<th>아이디(이메일)</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>사진</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>

		<%
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			String jdbcUrl = "jdbc:apache:commons:dbcp:test";

			try {
				// 2. (연결) 커넥션개체 생성
				// conn = DriverManager.getConnection(url, user, password);
				// 커넥션 풀을 이용한다.
				conn = DriverManager.getConnection(jdbcUrl);

				// 3. Statement 객체 생성
				stmt = conn.createStatement();

				String list_sql = "select idx, userid, password, username, userphoto, regdate from member order by idx";

				// 4. 쿼리 실행
				rs = stmt.executeQuery(list_sql);

				if (rs.next()) {
					do {
		%>

		<tr>
			<td><%=rs.getInt("idx")%></td>
			<td><%=rs.getString("userid")%></td>
			<td><%=rs.getString("password")%></td>
			<td><%=rs.getString("username")%></td>
			<td><img src="<%=request.getContextPath()%>/uploadfile/${fileName}" /></td>
			<td><%=rs.getString("regdate")%></td>
			<td><a href="editForm.jsp?userid=<%=rs.getString("userid")%>">수정</a>
				<a href="delete.jsp?userid=<%=rs.getString("userid")%>">삭제</a></td>
				<%-- <%
					System.out.println(request.getContextPath());
				%> --%>
		</tr>
		<%
			} while (rs.next());
				} else {
		%>

		<tr>
			<td colspan="7">등록된 회원정보가 없습니다.</td>
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