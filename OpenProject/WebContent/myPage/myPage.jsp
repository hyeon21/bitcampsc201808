<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.open.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String)request.getSession(false).getAttribute("userId"); // 키는 스트링, 밸류는 오브젝트타입이라 형변환이 필요
	String name = ""; // DB에서 뽑아낸 이름을 저장할 변수
	String photo = ""; // DB에서 뽑아낸 사진파일명을 저장할 변수
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String jdbcUrl = "jdbc:apache:commons:dbcp:test";
	
	if(id == null){
		%>
<script>
	alert("로그인 후 사용 가능한 서비스입니다.");
	location.href = 'loginForm.jsp';
</script>
<%
	} else {

		try {
	// 2. (연결) 커넥션개체 생성
	// conn = DriverManager.getConnection(url, user, password);
	// 커넥션 풀을 이용한다.
	conn = DriverManager.getConnection(jdbcUrl);

	// 3. Statement 객체 생성
	stmt = conn.createStatement();

	String list_sql = "select userid, username, userphoto from member where userid='" + id + "'";

	// 4. 쿼리 실행
	rs = stmt.executeQuery(list_sql);

		if (rs.next()) {
			id = rs.getString("userid");
			name = rs.getString("username");
			photo = rs.getString("userphoto");
		} 
	}finally {
			stmt.close();
			conn.close();
		}
		
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2, td {
	padding: 10px;
}

#memberPhoto {
	width: 150px;
	height: 150px;
	border: 1px solid #333333;
	border-radius: 75px;
	margin: 20px 0;
	text-align: center;
}
</style>
</head>
<body>

	<%@ include file="../common/header.jsp"%>
	<div id="contents">
		<h2>회원 정보</h2>

		<div id="memberPhoto">
			<img src="../images/<%=photo%>">
		</div>

		<hr>
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td><%= id %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%= name %></td>
			</tr>
		</table>
	</div>
</body>
</html>
<%} %>