package p3AnonymousClass;
// useful for using object one time.
public class Demo {

	public static void main(String[] args) {
		InterfaceCalculator calc1 = new InterfaceCalculator() {

			@Override
			public int square(int number) {
				return number * number;
			}
			
		};
		
		System.out.println(calc1.square(5));
	}

}
