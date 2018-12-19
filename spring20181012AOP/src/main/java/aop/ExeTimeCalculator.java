package aop;

public class ExeTimeCalculator implements Calculator {

	// 프록시
	// 실행을 대행한다
	// 대행하기 위한 객체가 필요
	// 핵심코드 + 부가적인 기능
	
	private Calculator delegate;
	
	// 실행을 위한 객체를 받는다
	public ExeTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
		}
	
	@Override
	public long factorial(long num) {
	
		long startTime = System.nanoTime();
		
		long result = delegate.factorial(num);
		
		long endTime = System.nanoTime();
		
		System.out.println("factorial(" + num + ") 실행시간 " + (endTime - startTime));
		
		
		return result;
	}

}
