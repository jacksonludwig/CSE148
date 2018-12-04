package file_utils;

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
		long randomByteNumber;
		String randomWord = null;
		try {
			do {
				randomByteNumber = new Random()
						.nextInt((int) randomFile.length() - (readLastLine(filename).length() * 2));
				randomFile.seek(randomByteNumber);
				if (randomFile.readChar() == '\n') {
					randomFile.seek(randomByteNumber + 2);
				}
				randomFile.readLine();
				randomWord = randomFile.readLine();
			} while (randomByteNumber >= randomFile.length());

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
		String currentLine = "";
		try {
			while ((currentLine = input.readLine()) != null) {
				last = currentLine;
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return last;
	}

	public static boolean isDouble(String number) {
		try {
			Double.parseDouble(number);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}