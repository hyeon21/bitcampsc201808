<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문하기</title>
</head>
<body>

	<form method="post">
	
	상품1:ID <input type="text" name="orderItems[0].itemId"><br>
	상품1:개수 <input type="text" name="orderItems[0].number"><br>
	상품1:주의 <input type="text" name="orderItems[0].remark"><br>
	<br>
	
	상품2:ID <input type="text" name="orderItems[1].itemId"><br>
	상품2:개수 <input type="text" name="orderItems[1].number"><br>
	상품2:주의 <input type="text" name="orderItems[1].remark"><br>
	<br>
	상품3:ID <input type="text" name="orderItems[2].itemId"><br>
	상품3:개수 <input type="text" name="orderItems[2].number"><br>
	상품3:주의 <input type="text" name="orderItems[2].remark"><br>
	<br>
	배송지<br>
	우편번호 <input type="text" name="address.zipCode"><br>
	주소 1 <input type="text" name="address.address1"><br>
	주소 2 <input type="text" name="address.address2"><br>
	
	<br>
	<input type="submit">
	
	
	
	
	
	
	
	
	</form>

</body>
</html>