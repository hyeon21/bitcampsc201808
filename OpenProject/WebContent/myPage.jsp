<%@page import="java.util.List"%>
<%@page import="com.open.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String)request.getSession(false).getAttribute("userId"); // 키는 스트링, 밸류는 오브젝트타입이라 형변환이 필요
	String name = ""; // 애플리케이션의 멤버리스트에서 뽑아낸 이름을 저장할 변수
	String photo = ""; // 애플리케이션의 멤버리스트에서 뽑아낸 사진파일명을 저장할 변수
	List<Member> memberList = (List<Member>)application.getAttribute("members");
	
	if(id == null){
		%>
		<script>
			alert("로그인 후 사용 가능한 서비스입니다.");
			location.href = 'loginForm.jsp';
		</script>
		<%
	} else {
		
		// 애플리케이션에 저장된 멤버 리스트중에서 일치하는 id를 찾아 해당 name을 변수에 저장.
		for(int i=0; i<memberList.size(); i++){
			if(id.equals(memberList.get(i).getUserId())){
				name = memberList.get(i).getUserName();
				photo = memberList.get(i).getUserPhoto();
				break;
			}
		}
		
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

<%@ include file="common/header.jsp" %>
<div id="contents">
		 <h2>회원 정보</h2>
		 
		 <div id="memberPhoto"><img src="./images/<%=photo%>"></div>

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