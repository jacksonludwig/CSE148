package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Utilities {
	public static String generateRandomLineFromFile(String filename) {
		RandomAccessFile randomFile = null;
		try {
			randomFile = new RandomAccessFile(filename, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Random rand = new Random();
		int randomValue;
		long randomByteNumber;
		String randomWord = null;

		try {
			do {
				// Makes sure that the random position that the pointer is set to is never the
				// last line of the file
				randomValue = rand.nextInt((int) randomFile.length() - (readLastLine(filename).length() * 2));
				randomByteNumber = randomValue;
				randomFile.seek(randomByteNumber);
				if (randomFile.readChar() == '\n') {
					randomFile.seek(randomByteNumber + 2);
				}
				randomFile.readLine();
				randomWord = randomFile.readLine();
			} while (randomByteNumber >= randomFile.length() || randomWord.equals("null"));

			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return randomWord;
	}

	public static String readLastLine(String filename) {
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader input = new BufferedReader(fr);
		String last = "";
		String line = "";

		try {
			while ((line = input.readLine()) != null) {
				last = line;
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return last;
	}

}
