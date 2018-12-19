package com.bitcamp.mvc1015;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 이게 있어야 핸들러맵핑에 들어간다. 
public class HelloController {
	
	@RequestMapping("/hello") // /hello가 들어오면 아래의 메서드(or클래스)를 실행한다. 뷰네임 반환. 
	public ModelAndView hello() {	// 모델앤뷰는 스프링 서블릿에...
		
		ModelAndView modelAndView = new ModelAndView();
		
		// 컨트롤러는 뷰의 이름을 반환해주어야 한다.
		modelAndView.setViewName("hello");  // WEB-INF/views/hello.jsp 로 들어가게 된다. WEB-INF/views/는 서블릿-컨텍스트.xml에서 설정
		
		// 결과데이터를 Model에 저장 후 공유
		modelAndView.addObject("greeting", getGreeting());
		
		
		return modelAndView;
	}

	private Object getGreeting() {
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		String str="";
		
		if(6 <= hour && hour <=10) {
			str="힘세고 강한 아침!";
		}else if(12 <= hour && hour <= 15) {
			str="점심 식사 하셨나요?";
		}else{
			str="언제 퇴근하나요?";
		}
		
		return str;
	}
	
}
