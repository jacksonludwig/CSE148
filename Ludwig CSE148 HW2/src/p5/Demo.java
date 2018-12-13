package p5;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		
		Book b1 =  new Book();
		Book b2 =  new Book();
		
		System.out.println("Please enter the book title: ");
		b1.setTitle(kboard.nextLine());
		System.out.println("Please enter the book author: ");
		b1.setAuthor(kboard.nextLine());
		System.out.println("Please enter the book price: ");
		b1.setPrice(kboard.nextDouble());
		
		System.out.println(b1 + "\n");
		kboard.nextLine();
		
		System.out.println("Please enter the book title: ");
		b2.setTitle(kboard.nextLine());
		System.out.println("Please enter the book author: ");
		b2.setAuthor(kboard.nextLine());
		System.out.println("Please enter the book price: ");
		b2.setPrice(kboard.nextDouble());
		
		System.out.println(b2);
	}

}
