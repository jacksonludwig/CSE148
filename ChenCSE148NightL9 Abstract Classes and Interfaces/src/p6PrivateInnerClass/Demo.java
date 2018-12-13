package p6PrivateInnerClass;

public class Demo {
	
	public static void main(String[] args) {
		//blahblahblah use it here.
	}
	
	
	private class Calculator implements InterfaceCalculator {

		@Override
		public int square(int number) {
			return number * number;
		}
		
	}
	
}


