package p1;
import java.util.Scanner; 

public class Name {
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = kboard.nextLine();
		kboard.close();
		System.out.println("Your name is: " + name);
	}
	
}
