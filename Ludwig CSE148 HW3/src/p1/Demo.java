package p1;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		Pet p1 = new Pet();
		System.out.println("Please enter the pet's name: ");
		p1.setName(kboard.next()); 
		System.out.println("Please enter the pet's type: ");
		p1.setType(kboard.next());
		System.out.println("Please enter the pet's age: ");
		p1.setAge(kboard.nextInt());
		
		System.out.println("\n" + p1.getName() + ", " + p1.getType() + ", " + p1.getAge());
	}
	
	
}
