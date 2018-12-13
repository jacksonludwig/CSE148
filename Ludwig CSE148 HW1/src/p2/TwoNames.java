package p2;
import java.util.Scanner; 

public class TwoNames {
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String username = kboard.nextLine();
		System.out.println("Please enter your significant other's name: ");
		String userSO = kboard.nextLine();
		kboard.close();
		System.out.println("Your names are: " + username + " & " + userSO );
	}
}
