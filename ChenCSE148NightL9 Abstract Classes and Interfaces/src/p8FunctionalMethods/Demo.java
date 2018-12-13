package p8FunctionalMethods;

public class Demo {

	public static void main(String[] args) {
		// there is only one method in the interface with two parameters so it is obvious what is being referenced here.
		InterfaceCalculator add = (x, y) -> x + y;
		InterfaceCalculator subtract = (x, y) -> x - y;
		InterfaceCalculator multiply = (x, y) -> x * y;
		InterfaceCalculator divide = (x, y) -> x / y;
		// allows multiple DIFFERENT implementations of the SINGLE method.
		
		System.out.println(add.calculate(5, 2));
		System.out.println(subtract.calculate(5, 2));
		System.out.println(multiply.calculate(5, 2));
		System.out.println(divide.calculate(5, 2));
		
		System.out.println(add.squareIt(5));
	}

}
