<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Book</title>
<link rel="stylesheet" href="../css/default.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
*{
text-decoration: none;
}
h1, h2, h3{
margin: 10px;
}
table{
	width: 1000px;
	border: 1px solid black;
}
td{
	border: 1px solid black;
	padding: 10px;
}
.center{
text-align: center;
}
.likeTd{
text-align: center;
}

</style>

</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<h3><a href="writeMessage">메세지 남기기</a></h3>

	<c:if test="${viewData.isEmpty() }">
		작성된 방명록 메세지가 없습니다.
	</c:if>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>게시글</th>
			<th>좋아요</th>
			<th>관리</th>
		</tr>
	

	
	<c:if test="${!viewData.isEmpty() }">
		<c:forEach var="message" items="${viewData.messageList}">
			<tr>
				<td id="mNo_${message.messageId}" class="center" width=50>${message.messageId}</td>
				<td width=60>${message.userId}</td>
				<td>${message.message}</td>
				<td class="likeTd" id="like_${message.messageId}" width=50>
					<c:if test="${likeList.isEmpty()}">
						0
					</c:if>
					
					<c:if test="${!likeList.isEmpty() }">
						<c:forEach var="like" items="${likeList }">
							<c:if test="${message.messageId eq like.messageId}">
								${like.likeCnt}
							</c:if>
						</c:forEach>
					</c:if>
					</td>
				
				<td class="center" width=320>
				<button id="is_${message.messageId}_${loginInfo.idx}" class="likeBnt" value="${message.messageId}">좋아요</button>
					<a href="messageDetailView/${message.messageId}">[상세보기]</a>
					
					<c:if test="${loginInfo.userId eq message.userId or loginInfo.userId eq 'hyeon21'}">
					<a href="deleteMessage?id=${message.messageId}">[삭제하기]</a>
					</c:if>
					
					<a href="comment?messageId=${message.messageId}">[댓글달기]</a>
					<button class="commBtn" value="${message.messageId}">댓글...댓글을 보자!</button>
					</td>
					
				</tr>
			<!-- ---------------------------------------------------- -->
				<tr id="commHidden_${message.messageId}" style="display:none;">
					<%-- <td id="comm_${message.messageId}" colspan="6" >ss</td> --%>
				</tr>
					</c:forEach>
			</c:if>
		</table>
		
		
		<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
			<a href="bookList?page=${num}">[${num}]</a>
		</c:forEach>
		





<script>
$(document).ready(function(){
	var userIdx = ${loginInfo.idx}
	$.ajax({
 		type: "GET",
		url: "isLike",
		data: {"userIdx":userIdx},
 		success: function(isLike){
 			if(isLike.length>0){
 				for(var i=0; i<isLike.length; i++){
 					var mId = isLike[i].messageId;
 						$('#is_'+mId+'_'+userIdx).empty();
				 		$('#is_'+mId+'_'+userIdx).append("안좋아요");
 					 }
 				}
 			}
	});
});

</script>





<script>
	$('.commBtn').click(function() {
		var msgId = $(this).val();
		alert(msgId);
			var commList = [];
			var comm = "<td colspan=6>";
		 
			status = $('#commHidden_'+msgId).css("display");
			if(status=="none"){
				status = $('#commHidden_'+msgId).css("display", "");
				
				$.ajax({
					type: "GET",
					url: "viewComment",
					data: {"msgId":msgId},
					dataType: "JSON",
				 	success: function(data){
				 		commList = data;
				 		console.log(commList);
				 		
				 		if(commList.length==0){
				 			comm += 'NO COMMENT!';
				 		}else{
				 			for(var i=0; i<commList.length; i++){
				 				console.log(commList[i]);
				 				comm += '댓글번호 : '+commList[i].commentNo+'<br>';
				 				comm += '작성자 : '+commList[i].userId+'<br>';
				 				comm += '코멘트 : '+commList[i].comment+'<br>';
				 				comm += '<c:if test="uId eq commList[i].userId">';
				 				comm += '<a href="deleteComment?commentNo='+commList[i].commentNo+'">[삭제하기]</a>';
				 				comm += '<a href="editComment?commentNo='+commList[i].commentNo+'">[수정하기]</a><br><br>';
				 				comm += '</c:if>';
				 			}
				 		}
				 		comm += '</td>';
				 		$('#commHidden_'+msgId).empty();
				 		$('#commHidden_'+msgId).append(comm);
				 	}
				});
				
			}else{
				status = $('#commHidden_'+msgId).css("display", "none");
			}
	});
</script>		
		
<script>
	$('.likeBnt').click(function() {
		if($(this).html()=='좋아요'){
			$(this).html('안좋아요');
		}else{
			$(this).html('좋아요');
		}
		
		var messageId = $(this).val();
		var userIdx = ${loginInfo.idx}
		 $.ajax({
		 	type: "POST",
			url: "likeMessage",
			data: {"messageId":messageId, "userIdx":userIdx},
		 	success: function(data){
		 		$('#like_'+messageId).empty(),
				$('#like_'+messageId).append(data);
		 	}                                                             
		});
	});
</script>

</body>
</html>