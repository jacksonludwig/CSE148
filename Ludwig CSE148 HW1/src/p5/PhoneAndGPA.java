package p5;

import java.util.Scanner;

public class PhoneAndGPA {

	public static void main(String[] args) {
		while(true) {
			Scanner kboard = new Scanner(System.in);
			System.out.printf("Enter your name: ");
			String name = kboard.nextLine();
			System.out.printf("Enter your GPA: ");
			double gpa = kboard.nextDouble();
			System.out.printf("Enter your Phone Number: ");
			long phone = kboard.nextLong();
			System.out.printf("Name: " + name + ", " + "GPA: " + gpa + ", " +
			"Phone: " + phone);
			
			System.out.printf("\n \n");
		}

	}

}
