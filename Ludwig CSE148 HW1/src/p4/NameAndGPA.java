package p4;
import java.util.Scanner;

public class NameAndGPA {

	public static void main(String[] args) {
		
		while(true) {
			Scanner kboard = new Scanner(System.in);
			System.out.println("Enter your name: ");
			String name = kboard.nextLine();
			System.out.println("Enter your GPA: ");
			double gpa = kboard.nextDouble();
			System.out.println("Name: " + name + ", " + "GPA: " + gpa);
			
			System.out.println();
		}
		
		

	}

}
