package p1ReadAndWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadTextFile {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Names.txt");
		Scanner kboard = new Scanner(file);
		while (kboard.hasNextLine() == true) {
			String str = kboard.nextLine();
			String[] tokens = str.split(" ");
			System.out.println(Arrays.toString(tokens));
		}
		kboard.close();

	}

}
