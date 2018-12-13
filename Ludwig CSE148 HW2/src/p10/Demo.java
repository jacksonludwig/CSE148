package p10;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		circle1();
		circle2();
	}

	public static void circle1() {
		Scanner kboard = new Scanner(System.in);
		Circle c1 = new Circle();
		System.out.println("Enter the circle's radius: ");
		c1.setRadius(kboard.nextDouble());
		
		System.out.println("The circle's area is " + String.format("%.2f", c1.calcArea()) + "\n");
	}
	
	public static void circle2() {
		Scanner kboard = new Scanner(System.in);
		Circle c1 = new Circle();
		System.out.println("Enter the second circle's radius: ");
		c1.setRadius(kboard.nextDouble());
		
		System.out.println("The circle's area is " + String.format("%.2f", c1.calcArea()));
	}
}
