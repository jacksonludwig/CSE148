package p1TextFileGenerators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Textbook {
	private String title;
	private String authorName;
	private String ISBN;
	private String price;

	private final static int DIGITS_IN_ISBN = 13;
	private final static double MINIMUM_PRICE = 0.1;
	private final static double MAXIMUM_PRICE = 200.0;

	public Textbook() throws IOException {
		title = generateTitle();
		authorName = generateAuthor();
		ISBN = generateISBN();
		price = Utilities.generateDoubleInRange(MINIMUM_PRICE, MAXIMUM_PRICE);
	}

	public static String generateTitle() throws IOException {
		return Utilities.generateRandomWordFromFile("words.txt") + " "
				+ Utilities.generateRandomWordFromFile("words.txt") + " "
				+ Utilities.generateRandomWordFromFile("words.txt");
	}

	public String generateAuthor() throws IOException {
		return Utilities.generateRandomWordFromFile("firstnames.txt") + " "
				+ Utilities.generateRandomWordFromFile("lastnames.txt");
	}

	public String generateISBN() {
		Random rand = new Random();
		int randomValue;
		String ISBN = "";

		for (int i = 0; i < DIGITS_IN_ISBN; i++) {
			if (i == 3 || i == 6 || i == 10) {
				ISBN = ISBN + '-';
			}
			randomValue = rand.nextInt(10);
			ISBN = ISBN + randomValue;
		}
		return ISBN;
	}

	@Override
	public String toString() {
		return title + "; " + authorName + "; " + ISBN + "; " + price;
	}

}
