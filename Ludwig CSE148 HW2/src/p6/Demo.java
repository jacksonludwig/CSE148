package p6;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		System.out.println(person1());
		System.out.println(person2());
	}
	
	public static String person1() {
		Persons p1 = new Persons();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter the person's Name: ");
		p1.setName(kboard.nextLine());
		System.out.println("Enter the person's SS#: ");
		p1.setSSnum(kboard.nextLine());
		System.out.println("Enter the person's age: ");
		p1.setAge(kboard.nextInt());
		
		return p1.toString();
	}
	
	public static String person2() {
		Persons p2 = new Persons();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter the person's Name: ");
		p2.setName(kboard.nextLine());
		System.out.println("Enter the person's SS#: ");
		p2.setSSnum(kboard.nextLine());
		System.out.println("Enter the person's age: ");
		p2.setAge(kboard.nextInt());
		
		return p2.toString();
	}

}
