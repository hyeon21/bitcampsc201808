<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script>
	$(document).ready(function() { // html 화면이 다 로드가 된 후!

		/* $.ajax('data.jsp', {
			success : function(data) {
				// 선택자로 문서객체 지정하기
				$('body').append(data); // 대상.append  => 바디 뒤쪽으로 추가하기 
			}
		}); // 메서드입니다... 현재 페이지 기준으로 들어갑니다. 현재 같은 폴더에 들어있음
		 */

		/* $.ajax({
			url : 'data.jsp',
			data : {id:'hyeon', pw:'1111'},
			success : function(data) {
				// 선택자로 문서객체 지정하기
				$('body').append(data); // 대상.append  => 바디 뒤쪽으로 추가하기 
			}
		}); // 메서드입니다... 현재 페이지 기준으로 들어갑니다. 현재 같은 폴더에 들어있음 */

		/* $.get('data.jsp', function(data) {
			$('body').append(data);
		}); */

		/* $.post('data.jsp', function(data) {
			$('body').append(data);
		}); */

	/* 	var id = $('#uid').val();  //'hyeon';
		var pw = $('#upw').val();  //'0221'; */


		/* var udata = {
				id : id,
				pw : pw
		}; */
		
		/* $('body').load('data.jsp?id=hot&pw=3333'); // 가장 간단하게 처리가능하지만 컨트롤할 수 있는 옵션이 없음. */
		// $('body').load('data.jsp?'+$.param(udata)); // 변수넣어 처리하기.

 		/* $.ajax({
			url : 'data.jsp',
			data : {
				id : id,
				pw : pw
			},
			success : function(data) {
				// 선택자로 문서객체 지정하기
				$('body').append(data); // 대상.append  => 바디 뒤쪽으로 추가하기 
			}
		}); // 메서드입니다... 현재 페이지 기준으로 들어갑니다. 현재 같은 폴더에 들어있음
	 */
		
		
	 	$.getJSON('dataJson.jsp', function(data){
			$.each(data, function(key, value){  // each(원본데이터, 펑션핸들러)
				var htmlStr = '<h1> '+ value.name +' : '+ value.price +'원</h1>';
				$('body').append(htmlStr);
			});  
			
		});
		
		
		/* $.ajax({
			url : 'dataXml.jsp',
			success : function(data){
				
				$(data).find('product').each(function(){
					var name = $(this).find('name').text();
					var price = $(this).find('price').text();
					var htmlStr = '<h1>'+name+' : '+price+'원</h1>';
					$('body').append(htmlStr);
					
				});
			}
			
		}); */
		
		
/* 		var data = {
				name : 'cool',
				loc : 'seoul'
		};
		
		
		$('<h1></h1>').text($.param(data)).appendTo('body'); */
		
	/* $('#my-form').submit(function(event){
		
		$('#wrap').load('data.jsp', $(this).serialize());
		
		event.preventDefault();
		
	});
		 */
		
		
	});
</script>

</head>
<body>
<form id="my-form">
	<input type="text" id="uid" name="id" value="runngun21@naver.com">
	<input type="password" id="upw" name="pw" value="test">
	<input type="submit">
</form>
<div id="wrap"></div>

</body>
</html>