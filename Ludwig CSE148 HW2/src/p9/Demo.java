package p9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		student1();
		student2();
		student3();
	}
	
	public static void student1() {
		Student s1 = new Student();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		s1.setFirstName(kboard.next());
		System.out.println("Enter student last name: ");
		s1.setLastName(kboard.next());
		System.out.println("Enter student ID: ");
		s1.setId(kboard.next());
		System.out.println("Enter number of classes student is taking: ");
		
		int numberOfClasses = kboard.nextInt();
		ArrayList<String> tempClassList = new ArrayList<String>();
		for(int i = 1; i < numberOfClasses + 1; i++) {
			System.out.println("Please enter class " + i + ":");
			tempClassList.add(kboard.next());
		}
		
		s1.setClasses(tempClassList);
		
		System.out.println("Enter student gpa: ");
		s1.setGpa(kboard.nextDouble());
		
		System.out.println(s1);
	}
	
	public static void student2() {
		Student s1 = new Student();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		s1.setFirstName(kboard.next());
		System.out.println("Enter student last name: ");
		s1.setLastName(kboard.next());
		System.out.println("Enter student ID: ");
		s1.setId(kboard.next());
		System.out.println("Enter number of classes student is taking: ");
		
		int numberOfClasses = kboard.nextInt();
		ArrayList<String> tempClassList = new ArrayList<String>();
		for(int i = 1; i < numberOfClasses + 1; i++) {
			System.out.println("Please enter class " + i + ":");
			tempClassList.add(kboard.next());
		}
		
		s1.setClasses(tempClassList);
		
		System.out.println("Enter student gpa: ");
		s1.setGpa(kboard.nextDouble());
		
		System.out.println(s1);
	}
	
	public static void student3() {
		Student s1 = new Student();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		s1.setFirstName(kboard.next());
		System.out.println("Enter student last name: ");
		s1.setLastName(kboard.next());
		System.out.println("Enter student ID: ");
		s1.setId(kboard.next());
		System.out.println("Enter number of classes student is taking: ");
		
		int numberOfClasses = kboard.nextInt();
		ArrayList<String> tempClassList = new ArrayList<String>();
		for(int i = 1; i < numberOfClasses + 1; i++) {
			System.out.println("Please enter class " + i + ":");
			tempClassList.add(kboard.next());
		}
		
		s1.setClasses(tempClassList);
		
		System.out.println("Enter student gpa: ");
		s1.setGpa(kboard.nextDouble());
		
		System.out.println(s1);
	}

}
