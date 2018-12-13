package p8;

import java.util.Scanner;

public class CheckInput {
	public static void main(String[] args) {
		System.out.println("\t\tBurger King");
		
		System.out.println("\t1300 Deer Park Ave, North Babylon, NY 11703");
		System.out.println("\t\t(631)-473-6857");
		System.out.println();
		
		System.out.println("Cashier: Sam");
		System.out.println();
		
		Scanner kboard = new Scanner(System.in);
		
		System.out.println("Please enter your first item:");
		String itemOne = kboard.nextLine();
		System.out.println("Please the amount you would like:");
		int oneAmount = kboard.nextInt();
		
		System.out.println("Please enter your second item:");
		kboard.nextLine();
		String itemTwo = kboard.nextLine();
		System.out.println("Please the amount you would like:");
		int twoAmount = kboard.nextInt();
		
		System.out.println("Please enter your third item:");
		kboard.nextLine();
		String itemThree = kboard.nextLine();
		System.out.println("Please the amount you would like:");
		int threeAmount = kboard.nextInt();
		
		System.out.println("Please enter your fourth item:");
		kboard.nextLine();
		String itemFour = kboard.nextLine();
		System.out.println("Please the amount you would like:");
		int fourAmount = kboard.nextInt();
		
		System.out.println(itemOne + "(2.00)" + " " + oneAmount);
		System.out.println(itemTwo + "(3.00)" + " " + twoAmount);
		System.out.println(itemThree + "(1.00)" + " " + threeAmount);
		System.out.println(itemFour + "(2.00)" + " " + fourAmount);
		
		double subtotal = 2.00 * oneAmount + 3.00 * twoAmount + 1.00 * threeAmount + 2.00 * fourAmount;
		double tax = subtotal * .08625;
		double total = subtotal + tax;
		
		System.out.println("Subtotal: " + subtotal);
		System.out.println("Tax: " + String.format("%.2f", tax));
		System.out.println("Total: " + String.format("%.2f", total));
		
	}
}
