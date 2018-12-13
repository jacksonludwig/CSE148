package p7DefaultMethod;

public interface InterfaceCalculator {
	// interfaces can have DEFAULT or STATIC methods (still nothing but public modifier).
	static int square(int number) {
		return number * number;
	}
	
	// int doubleIt(int number);
}
