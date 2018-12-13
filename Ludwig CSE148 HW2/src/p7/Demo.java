package p7;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		Car car1 = new Car();
		
		System.out.println("Enter the car's color:");
		car1.setColor(kboard.next());
		System.out.println("Enter the car's year:");
		car1.setYear(kboard.nextInt());
		System.out.println("Enter the car's make:");
		car1.setMake(kboard.next());
		System.out.println("Enter the car's speed:");
		car1.setSpeed(kboard.nextInt());
		
		System.out.println("Initial info: " + "\n" + car1 + "\n");
		car1.speedUp();
		car1.speedUp();
		car1.speedUp();
		car1.speedUp();
		car1.speedUp();
		car1.slowDown();
		car1.slowDown();
		car1.slowDown();
		car1.slowDown();
		System.out.println("Final info: " + "\n" + car1);
	}

}
