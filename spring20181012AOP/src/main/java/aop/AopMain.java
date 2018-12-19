package aop;

public class AopMain {

	public static void main(String[] args) {

		RecCalculator recCalculator = new RecCalculator();
		ImpCalculator impCalculator = new ImpCalculator();
		
		System.out.println("프록시를 이용한 처리");
		
		System.out.println("=============================");
		//												프록시
		System.out.println("1. factorial 결과 : " + new ExeTimeCalculator(recCalculator).factorial(10));
		
		System.out.println("=============================");
		
		System.out.println("2. for 결과 : " + new ExeTimeCalculator(impCalculator).factorial(10));
		
		
		/*long resultTime1 = new RecCalculator().factorial(100);
		System.out.println("factorial(100) 결과 " + resultTime1);
		
		System.out.println("=================================");
		
		long resultTime2 = new ImpCalculator().factorial(100);
		System.out.println("factorial(100) 결과 " + resultTime2);*/
		
	}
}
