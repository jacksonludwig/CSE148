package cleanText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CleanText {

	public static void main(String[] args) throws IOException {
		File file = new File("text/CoursesUnformatted.txt");
		Scanner scanner = new Scanner(file);
		
		FileWriter fw = new FileWriter(file);
		String stuff = "";
		int count1 = 0;
		int count2 = 0;
		while(scanner.hasNextLine()) {
			count1++;
			
			if(count1 % 5 == 0) {
				
			} else {
				scanner.nextLine();
			}
		}
	}

}
