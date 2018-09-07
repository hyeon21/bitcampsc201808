<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String)request.getSession(false).getAttribute("userId"); // 키는 스트링, 밸류는 오브젝트타입이라 형변환이 필요
	String name = (String)request.getSession(false).getAttribute("userName");
	
	if(id == null){
		%>
		<script>
			alert("로그인 후 사용 가능한 서비스입니다.");
			location.href = 'loginForm.jsp';
		</script>
		<%
	} else {
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
 h2, td{
 padding: 10px;
 }
 
 #memberPhoto{
 background-image: url('images/nrp5.png');
 background-size: 100%;
 width: 150px;
 height: 150px;
 border: 1px solid #333333;
 border-radius: 75px;
 margin: 20px 0;
 }
 
</style>
</head>
<body>

<%@ include file="common/header.jsp" %>
<div id="contents">
		 <h2>회원 정보</h2>
		 
		 <div id="memberPhoto"></div>

    <hr>
    <form action="memberReg.jsp" method="post">
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
    </form>
	</div>
</body>
</html>
<%} %>