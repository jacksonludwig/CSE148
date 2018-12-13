package p2;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter the radius: ");
		double radiusInput = kboard.nextDouble();
		
		Circle circle1 = new Circle(radiusInput);
		
		System.out.println(circle1);

	}

}
