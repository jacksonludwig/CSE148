package p1TextFileGenerators;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class Utilities {

	private final static int PHONE_NUMBER_LENGTH = 7;
	private final static int AMOUNT_OF_AREA_CODES = 4;
	private final static int HIGHEST_NUMBER_POSSIBLE = 9;

	// phone + major to go into student/person/faculty
	public static String generatePhoneNumber() {
		Random rand = new Random();

		int[] areaCode = { 631, 516, 718, 212, 646 };
		String phoneNumber = String.valueOf(areaCode[rand.nextInt(AMOUNT_OF_AREA_CODES + 1)]);

		for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
			phoneNumber = phoneNumber + rand.nextInt(HIGHEST_NUMBER_POSSIBLE + 1);
		}

		return phoneNumber;
	}

	public static String generateMajor() {
		Random rand = new Random();

		Majors[] majors = Majors.values();
		String[] majorList = new String[majors.length];

		for (int i = 0; i < majors.length; i++) {
			majorList[i] = String.valueOf(majors[i]);
		}

		int randomMajorValue = rand.nextInt(majorList.length);

		return majorList[randomMajorValue];
	}

	public static String generateDoubleInRange(double minPrice, double maxPrice) {
		Random rand = new Random();
		double randomValue = minPrice + (maxPrice - minPrice) * rand.nextDouble();
		return String.format("%.2f", randomValue);
	}

	// needs try catch for eofexception (if at the last line, make it the line
	// before)

	public static String generateRandomWordFromFile(String filename) throws IOException {
		RandomAccessFile randomFile = new RandomAccessFile(filename, "r");
		Random rand = new Random();
		int randomValue;
		long randomByteNumber;
		String randomWord = null;

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
		return randomWord;
	}

	public static String readLastLine(String filename) throws IOException {
		Charset charset = Charset.forName("US-ASCII");
		File file = new File(filename);
		ReversedLinesFileReader readBackwards = new ReversedLinesFileReader(file, charset);
		String lastLine = readBackwards.readLine();
		readBackwards.close(); 
		return lastLine;
	}
	
	public static String getCourses() throws IOException {
		String randomLine = Utilities.generateRandomWordFromFile("Courses.txt");
		String course = "";
		int count = 0;
		while (randomLine.charAt(count) != ';') {
			course += randomLine.charAt(count);
			count++;
		}
		return course;
	}
}
