package p4RandomAccessFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteLetters {

	public static void main(String[] args) throws IOException {
		char[] letters = {'a','b','c','d','e','f'};
		RandomAccessFile randomFile = new RandomAccessFile("letters","rw");
		for(int i = 0; i < letters.length; i++) {
			randomFile.writeChar(letters[i]);
		}
		randomFile.close();
		System.out.println("done writing");
	}

}
