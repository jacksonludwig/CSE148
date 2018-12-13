package p8FunctionalMethods;

public interface InterfaceCalculator {
	// Functional method
	// IF you intend on using a functional method, there can be NO OTHER
	// unimplemented methods.
	int calculate(int number1, int number2);

	default int squareIt(int number) {
		return number * number;
	}

	default int doubleIt(int number) {
		return number * 2;
	}

}
