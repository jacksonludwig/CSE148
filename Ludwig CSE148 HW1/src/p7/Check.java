package p7;



public class Check {

	public static void main(String[] args) {
		System.out.println("\t\tBurger King");
		
		System.out.println("\t1300 Deer Park Ave, North Babylon, NY 11703");
		System.out.println("\t\t(631)-473-6857");
		System.out.println();
		
		System.out.println("Cashier: Sam");
		System.out.println();

		System.out.println("A Burger: $10.00");
		System.out.println("Second Burger: $8.00");
		System.out.println("Iced Tea: $5.00");
		System.out.println("Pepsi: $4.00");
		System.out.println("Subtotal: $" + (10 + 8 + 5 + 4));
		System.out.println("Tax: $" + String.format("%.2f", ((10 + 8 + 5 + 4) * .08625)));
		System.out.println("Total: $" + String.format("%.2f", ((10 + 8 + 5 + 4) + (10 + 8 + 5 + 4) * .08625)));
	}

}
