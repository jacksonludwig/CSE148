package recursion;

import java.math.BigDecimal;

public class Factorials {

	public static void main(String[] args) {
		System.out.println(factorial(25));
		System.out.println(Long.MAX_VALUE);
		BigDecimal bd1 = new BigDecimal("10000000000000000000000000000000000000000000000000");
		BigDecimal bd2 = bd1.divide(new BigDecimal(2));
		System.out.println(bd2.toString());
	}
	
	private static long factorial(int n) {
		if(n == 0) { // base case
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
