package p2Interfaces;

// the "implements" keyword is used in place of "extends" for interfaces.
// classes that implement interfaces are known as subclasses but interaces arent really superclasses.
public class Calculator implements InterfaceCalculator {

	@Override
	public int square(int number) {
		return number * number;
	}

}
