<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 컨트롤러 역할~1~4
	// 1. 사용자가 요청한 데이터 받기
	// 2. 요청 분석
	// 3. 처리 -> 결과 -> 기본객체에 속성으로 저장
	// 4. 응답 페이지 지정
	// 5. 포워딩

	String code = request.getParameter("code"); // 데이터받아서
	String viewPage = ""; // 메서드 안에 들어가게 되는데 , 지역변수이므로 반드시 초기화!

	if(code.equals("A")){
		
		// 결과 데이터
		Date date = new Date();
		request.setAttribute("result", date);
		viewPage = "view/a.jsp";
		
	}else if(code.equals("B")){
		
		String str = "Hello~!!";
		request.setAttribute("result", str);
		viewPage = "view/b.jsp";
		
	}else if(code.equals("C")){
		
		int age = 12;
		request.setAttribute("result", ""+age); // 오브젝트타입에 인트형. 자동형변환 된다.
		viewPage = "view/c.jsp";
	}
%>

<jsp:forward page="<%=viewPage %>"/>






















