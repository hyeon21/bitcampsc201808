<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="css/default.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
.modal-footer{
	
}

</style>

</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
	
<button class="btn btn-toggle" data-toggle="modal" data-target="#regModal">Show / Hide</button>

<div class="modal" id="regModal">
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
      	<h2>회원가입 모달창 테스트</h2>
      </div>
      <div class="modal-body">
      
      
      <form method="post">
		    <div>
			<input type="email" name="userId" placeholder="아이디(이메일주소)" class="userRegFormInput" />
			</div>
			<div>
			<input type="password" name="userName" placeholder="비밀번호설정" class="userRegFormInput" />
			</div>
			<div>
			<input type="text" name="userPw" placeholder="이름" class="userRegFormInput" />
			</div>
			<br>
			<select>
				<option>월</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
				<option>10</option>
				<option>11</option>
				<option>12</option>
			</select>
			<input type="text" name="userDay" placeholder="일" class="userRegFormInput" />
			<input type="text" name="userYear" placeholder="년(4자)" class="userRegFormInput" />
			<br>
			<input type="submit" value="가입하기" />
		</form>
      
      
       
      </div>
      <div class="modal-footer">
      	푸터푸터
      </div>
    </div>
    </div>
</div>


<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>

$('#myModal').modal("toggle");
//반대로 모달상태를 전환함

$('#myModal').modal("hide");
//모달창 열기

$('#myModal').modal("show");
//모달창 닫음
</script>

</body>
</html>