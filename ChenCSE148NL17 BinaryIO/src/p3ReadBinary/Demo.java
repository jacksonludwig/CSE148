package p3ReadBinary;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("numbers");
		DataInputStream dis = new DataInputStream(fis);
		
		boolean endOfFile = false;
		
		while(endOfFile = false) {
			try {
				int num = dis.readInt(); // will cause exception when out of bounds.
				System.out.println(num + " ");
			} catch (IOException e) {
				endOfFile = true; // allows use of try-catch instead of if-else.
			}
		}
		
		dis.close();
		System.out.println("\ndone reading");

	}

}
