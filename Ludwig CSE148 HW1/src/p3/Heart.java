package p3;

import java.util.Scanner;

public class Heart {
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String username = kboard.nextLine();
		System.out.println("Please enter your significant other's name: ");
		String userSO = kboard.nextLine();
		kboard.close();
		System.out.println(username.substring(0, 1) + "\u2764" + userSO.substring(0,1));
	}

}
