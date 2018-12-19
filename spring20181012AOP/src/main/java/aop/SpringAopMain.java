package aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAopMain {

	public static void main(String[] args) {
		
		// 스프링은 컨테이너 생성부터
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopConfig.xml");
		
		RecCalculator recCalculator = ctx.getBean("cal1", RecCalculator.class);
		
		long calResult1 = recCalculator.factorial(10);
		
		System.out.println("재귀 factorial(10) 의 결과 : "+ calResult1);
		System.out.println("=================================");
		
		ImpCalculator impCalculator = ctx.getBean("cal2", ImpCalculator.class);
		
		long calResult2 = impCalculator.factorial(10);
		
		System.out.println("for factorial(10) 의 결과 : "+ calResult2);
	}

}
