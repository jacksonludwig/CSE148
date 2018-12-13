package p1ArrayIndexOutOfBounds;

import java.util.Arrays;

public class ArrayIndex {

	public static void main(String[] args) {
		int[] numbers = new int[5];
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 3;
		numbers[3] = 4;
		numbers[4] = 5;

		// exception below
		try {
			numbers[5] = 6;
			// ANYTHING BELOW WILL BE SKIPPED
			System.out.println("hi"); // JVM skips to catch

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught an ArrayIndexOutOfBoundsException Exception");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Caught an exception");
		}
		System.out.println(Arrays.toString(numbers));

	}

}
