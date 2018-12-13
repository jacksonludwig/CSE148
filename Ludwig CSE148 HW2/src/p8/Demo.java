package p8;

import java.util.Scanner;

import p6.Persons;

public class Demo {

	public static void main(String[] args) {
		rect1();
		rect2();
		rect3();
	}

	public static void rect1() {
		Rectangle r1 = new Rectangle();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter the length: ");
		r1.setLength(kboard.nextInt());
		System.out.println("Enter the width: ");
		r1.setWidth(kboard.nextInt());
		System.out.println("Enter the height: ");
		r1.setHeight(kboard.nextInt());
		
		System.out.println(r1.calcArea());
	}
	
	public static void rect2() {
		Rectangle r1 = new Rectangle();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter the length: ");
		r1.setLength(kboard.nextInt());
		System.out.println("Enter the width: ");
		r1.setWidth(kboard.nextInt());
		System.out.println("Enter the height: ");
		r1.setHeight(kboard.nextInt());
		
		System.out.println(r1.calcArea());
	}
	
	public static void rect3() {
		Rectangle r1 = new Rectangle();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter the length: ");
		r1.setLength(kboard.nextInt());
		System.out.println("Enter the width: ");
		r1.setWidth(kboard.nextInt());
		System.out.println("Enter the height: ");
		r1.setHeight(kboard.nextInt());
		
		System.out.println(r1.calcArea());
	}
}
