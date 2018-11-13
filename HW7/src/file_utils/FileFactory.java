package file_utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileFactory {

	private final static String FIRST_NAME_FILE = "inputData/FirstNames.txt";
	private final static String LAST_NAME_FILE = "inputData/LastNames.txt";
	private final static String BOOK_TITLE_FILE = "inputData/BookTitles.txt";
	private final static String BOOK_ISBN_FILE = "inputData/BookIsbns.txt";
	private final static String MAJOR_FILE = "inputData/Majors.txt";
	private static int personIDNumber = 0;
	private final static int NUMBER_OF_COURSES_TO_TAKE = 16;
	private final static int NUMBER_OF_COURSES_TAKING = 6;
	private final static int NUMBER_OF_COURSES_TAKEN = 7;

	private static String emit(Categories category) {
		switch (category) {
		case FIRST:
			return emitFirstName(FIRST_NAME_FILE);
		case LAST:
			return emitLastName(LAST_NAME_FILE);
		case BOOK_TITLE:
			return emitBookTitle(BOOK_TITLE_FILE);
		case BOOK_ISBN:
			return emitBookIsbn(BOOK_ISBN_FILE);
		case ID:
			return emitPersonId();
		case PHONE:
			return emitPhone();
		case COURSES_TO_TAKE:
			return emitCourses_To_Take((new Random()).nextInt(NUMBER_OF_COURSES_TO_TAKE + 1), MAJOR_FILE);
		case COURSES_TAKING:
			return emitCourses_Taking((new Random()).nextInt(NUMBER_OF_COURSES_TAKING + 1), MAJOR_FILE);
		case COURSES_TAKEN:
			return emitCourses_Taken((new Random()).nextInt(NUMBER_OF_COURSES_TAKEN + 1), MAJOR_FILE);
		default:
			return null;
		}
	}

	public static String spew(Categories... categories) {
		String data = "";
		for (int i = 0; i < categories.length; i++) {
			data += emit(categories[i]) + "*";
		}
		return data;
	}

	public static void makeStudentFile(int numberOfItems, String outputFileName) {
		PrintWriter pw = openFile(outputFileName);
		for (int i = 0; i < numberOfItems; i++) {
			pw.println(spew(Categories.FIRST, Categories.LAST, Categories.ID, Categories.PHONE,
					Categories.COURSES_TO_TAKE, Categories.COURSES_TAKING, Categories.COURSES_TAKEN));
		}
		pw.close();
	}

	public static void makeTextbookFile(int numberOfItems, String outputFileName) {
		PrintWriter pw = openFile(outputFileName);
		for (int i = 0; i < numberOfItems; i++) {
			pw.println(spew(Categories.BOOK_TITLE, Categories.FIRST, Categories.LAST, Categories.BOOK_ISBN));
		}
		pw.close();
	}

	private static PrintWriter openFile(String fileName) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);
			return pw;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String emitFirstName(String fileName) {
		StringBag firstNameBag = new StringBag(fileName);
		return firstNameBag.emitString();
	}

	public static String emitLastName(String fileName) {
		StringBag lastNameBag = new StringBag(fileName);
		return lastNameBag.emitString();
	}

	public static String emitBookTitle(String fileName) {
		StringBag bookTitleBag = new StringBag(fileName);
		return bookTitleBag.emitString();
	}

	public static String emitBookIsbn(String fileName) {
		StringBag bookIsbnBag = new StringBag(fileName);
		return bookIsbnBag.emitString();
	}

	public static String emitPersonId() {
		return String.valueOf(personIDNumber++);
	}

	public static String emitPhone() {
		int[] areacodes = { 631, 516, 718, 212, 646 };
		Random rand = new Random();
		String phoneNumber = String.valueOf(areacodes[rand.nextInt(areacodes.length)]);
		final int NUMBER_OF_DIGITS = 7;
		for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
			phoneNumber += String.valueOf(rand.nextInt(10));
		}
		return phoneNumber;

	}

	public static String emitCourses_To_Take(int numberOfCourses, String fileName) {
		Random rand = new Random();
		StringBag majorBag = new StringBag(fileName);
		StringBag courseNumberBag = new StringBag(majorBag.getNElems());
		for (int i = 0; i < majorBag.getNElems(); i++) {
			courseNumberBag.insert(majorBag.emitString() + String.valueOf(100 + rand.nextInt(100)));
		}
		String coursesToTake = "";
		int randomNumberOfCourses = (1 + new Random().nextInt(numberOfCourses + 1));
		for (int i = 0; i < randomNumberOfCourses; i++) {
			coursesToTake += courseNumberBag.emitString() + ",";
		}

		return coursesToTake;
	}

	public static String emitCourses_Taking(int numberOfCourses, String fileName) {
		Random rand = new Random();
		StringBag majorBag = new StringBag(fileName);
		StringBag courseNumberBag = new StringBag(majorBag.getNElems());
		for (int i = 0; i < majorBag.getNElems(); i++) {
			courseNumberBag.insert(majorBag.emitString() + String.valueOf(100 + rand.nextInt(100)));
		}

		String coursesTaking = "";
		int randomNumberOfCourses = (1 + new Random().nextInt(numberOfCourses + 1));
		for (int i = 0; i < randomNumberOfCourses; i++) {
			coursesTaking += courseNumberBag.emitString() + ",";
		}

		return coursesTaking;
	}

	public static String emitCourses_Taken(int numberOfCourses, String fileName) {
		Random rand = new Random();
		String[] grades = { "A", "B+", "B", "C+", "C", "D+", "D", "F" };
		StringBag majorBag = new StringBag(fileName);
		StringBag courseNumberBag = new StringBag(majorBag.getNElems());
		for (int i = 0; i < majorBag.getNElems(); i++) {
			courseNumberBag.insert(majorBag.emitString() + String.valueOf(100 + rand.nextInt(100)));
		}

		String coursesTaken = "";
		int randomNumberOfCourses = (1 + new Random().nextInt(numberOfCourses + 1));
		for (int i = 0; i < randomNumberOfCourses; i++) {
			coursesTaken += courseNumberBag.emitString() + "," + grades[(rand.nextInt(grades.length))] + ",";
		}

		return coursesTaken;
	}
}
