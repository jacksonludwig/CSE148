package p4RandomAccessFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadLetters {

	public static void main(String[] args) throws IOException {
		final int CHAR_SIZE = 2; // chars are 2 bytes long in binary files
		long byteNumber;
		char ch;
		
		RandomAccessFile randomFile = new RandomAccessFile("letters","r");
		ch = randomFile.readChar();
		System.out.println(ch);
		byteNumber = CHAR_SIZE * 4; // moves pointer 4 places right
		randomFile.seek(byteNumber);
		System.out.println(randomFile.readChar());
	}

}
