package aop;

public class ImpCalculator implements Calculator {

	@Override
	public long factorial(long num) {

		long result = 1;

		for (int i = 1; i <= num; i++) {
			result = result * i;
		}
	
		return result;
		
	}

}
