package recursion;

public class EndlessRecursion {
	private static int count = 0;

	public static void main(String[] args) {
		message();
	}

	public static void message() {
		if (count == 10) { // base case (stops infinite recursive calls).
			return;
		} else {
			System.out.println("hi" + ++count);
			message();
		}
	}

}
