package p1ReadAndWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteTextFile {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("Names.txt", true);
		PrintWriter pw = new PrintWriter(fw);
		pw.print("Jane");
		pw.close();

		File file = new File("Names.txt");
		System.out.println(file.length());
	}

}
