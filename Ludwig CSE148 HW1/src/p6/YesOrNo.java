package p6;

import java.util.Scanner;

public class YesOrNo {
	public static void main(String[] args) {
		String stopOrGo;
		do {
			Scanner kboard = new Scanner(System.in);
			System.out.println("Enter your name: ");
			String name = kboard.nextLine();
			System.out.println("Enter your GPA: ");
			double gpa = kboard.nextDouble();
			System.out.println("Name: " + name + ", " + "GPA: " + gpa);
			
			kboard.nextLine();
			
			System.out.println("Would you like to continue?");
			stopOrGo = kboard.nextLine();
		}while(stopOrGo.substring(0,1).equals("y") || stopOrGo.substring(0,1).equals("Y"));
		
	}

}
