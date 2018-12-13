package p4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Decryption {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Jackson\\Desktop\\Workspace 1\\Ludwig CSE148 HW6\\src\\p4\\encryptedClasses");
		FileWriter fw = new FileWriter("C:\\Users\\Jackson\\Desktop\\Workspace 1\\Ludwig CSE148 HW6\\src\\p4\\decryptedClasses");
		PrintWriter pw = new PrintWriter(fw);
		Scanner kboard = new Scanner(file);
		
		while (kboard.hasNextLine() == true) {
			String str = kboard.nextLine();
			char[] character = new char[str.length()];
			for(int i = 0; i < str.length(); i++) {
				character[i] = str.charAt(i);
			}
			
			//String[] tokens = str.split(" ");
			//System.out.println(Arrays.toString(tokens));
			for(int i = 0; i < character.length; i++) {
				pw.print((char)(character[i] - 10));
			}
		}
		pw.close();
		
		
	}
}
