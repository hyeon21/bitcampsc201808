package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 요청 파악(분석)
		String type = request.getParameter("type");
		
		// null, greeting, date 이 세개 중 하나가 들어올 수 있도록 처리해보자
		// list, write, delete
		
		// 응답객체 생성
		Object resultObject = null;
		String viewPage = "/simpleView.jsp";
		
		// 분기처리
		if(type == null || type.equals("greeting")) {
			resultObject = "안녕하세요!";
			viewPage = "/greeting.jsp";
		} else if (type.equals("date")) {
			resultObject = new Date();
			viewPage = "/date.jsp";
		} else {
			resultObject = "Invalid Type";
		}
		
		// 응답 데이터를 내장객체(request OR session)의 속성에 저장 : 공유, 전달목적
		request.setAttribute("result", resultObject);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); // 예외처리 필요
		
	}
}
