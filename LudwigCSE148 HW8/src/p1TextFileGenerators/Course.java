package p1TextFileGenerators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Course {
	private String courseNumber;
	private String courseTitle;
	private int numberOfCredits;
	private String courseDescription;
	private String facultyID;
	private String textbookISBN;
	private String classroom;

	private static final int DIGITS_IN_COURSE = 3;
	private static final int MAX_CREDITS = 4;
	private static final int MIN_CREDITS = 1;
	private static final int SIZE_OF_ISBN = 16;
	private static final int ELMS_OF_ROOM = 4;

	public Course() {
		courseNumber = generateCourseNumber();
		try {
			courseTitle = Textbook.generateTitle();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		numberOfCredits = generateCredits();
		try {
			courseDescription = generateDescription();
		} catch (IOException e) {
			e.printStackTrace();
		}
		facultyID = generatefacultyID();
		textbookISBN = getISBNFromFile();
		classroom = getClassroomNumberFromFile();
	}

	public String generateCourseNumber() {
		String major = Utilities.generateMajor();
		Random rand = new Random();
		for (int i = 0; i < DIGITS_IN_COURSE; i++) {
			major = major + (rand.nextInt(9) + 1);
		}
		return major;
	}

	public int generateCredits() {
		Random rand = new Random();
		return rand.nextInt(MAX_CREDITS - MIN_CREDITS + 1) + MIN_CREDITS;
	}

	public String generateDescription() throws IOException {
		String description = "";
		for (int i = 0; i < 50; i++) {
			description += Utilities.generateRandomWordFromFile("words.txt") + " ";
		}
		return description;
	}

	public String generatefacultyID() {
		String id = "";
		Random rand = new Random();
		for (int i = 0; i < 9; i++) {
			id += String.valueOf(rand.nextInt(10));
		}
		return id;
	}

	public String getISBNFromFile() {
		String randomLine = "";
		try {
			randomLine = Utilities.generateRandomWordFromFile("Textbooks.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ISBN = "";
		for (int i = 0; i < randomLine.length(); i++) {
			if (Character.isDigit(randomLine.charAt(i)) == true) {
				for (int j = i; j < i + SIZE_OF_ISBN; j++) {
					ISBN += randomLine.charAt(j);
				}
				break;
			}
		}
		return ISBN;
	}

	public String getClassroomNumberFromFile() {
		String randomLine = "";
		try {
			randomLine = Utilities.generateRandomWordFromFile("Classrooms.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String classroom = "";
		try {
			for (int i = 0; i < ELMS_OF_ROOM; i++) {
				classroom += randomLine.charAt(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classroom;
	}

	@Override
	public String toString() {
		return courseNumber + "; " + courseTitle + "; " + numberOfCredits + "; " + courseDescription + "; " + facultyID
				+ "; " + textbookISBN + "; " + classroom;
	}

}
