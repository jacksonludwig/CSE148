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
	private final static String COURSE_FILE = "inputData/Course_Inventory.txt";
	private final static String FORMATTED_COURSE_FILE = "outputData/CourseInventoryReformatted.txt";
	private static int personIDNumber = 0;
	private static int room = 100;
	private static final int MIN_SEATS_COMPUTERS = 12;
	private static final int MAX_SEATS_COMPUTERS = 30;
	private final static int NUMBER_OF_COURSES_TO_TAKE = 16;
	private final static int NUMBER_OF_COURSES_TAKING = 6;
	private final static int NUMBER_OF_COURSES_TAKEN = 7;
	private final static int NUMBER_OF_COURSES_TAUGHT = 3;

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
		case MAJOR:
			return emitMajor(MAJOR_FILE);
		case COURSES_TO_TAKE:
			return emitCourses_To_Take((new Random()).nextInt(NUMBER_OF_COURSES_TO_TAKE + 1), COURSE_FILE);
		case COURSES_TAKING:
			return emitCourses_Taking((new Random()).nextInt(NUMBER_OF_COURSES_TAKING + 1), COURSE_FILE);
		case COURSES_TAKEN:
			return emitCourses_Taken((new Random()).nextInt(NUMBER_OF_COURSES_TAKEN + 1), COURSE_FILE);
		case COURSES_TAUGHT:
			return emitCourses_Taking((new Random()).nextInt(NUMBER_OF_COURSES_TAUGHT + 1), COURSE_FILE);
		case SALARY:
			return emitSalary();
		case PRICE:
			return emitPrice();
		case ROOM_NUMBER:
			return emitRoomNumber();
		case BUILDING_NAME:
			return emitBuilding();
		case NUMBER_OF_SEATS:
			return emitNumberOfSeatsOrComputers();
		case NUMBER_OF_COMPUTERS:
			return emitNumberOfSeatsOrComputers();
		case PROJECTOR_OR_NOT:
			return emitProjectorOrNot();
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

	public static void completeCourseFile(int numberOfItems, String outputFilename) {
		String building;
		char buildingLetter;
		building = spew(Categories.BUILDING_NAME);
		buildingLetter = building.charAt(0);
		PrintWriter pw = openFile(outputFilename);
		for (int i = 0; i < numberOfItems; i++) {
			building = spew(Categories.BUILDING_NAME);
			buildingLetter = building.charAt(0);
			String dataLine = Utilities.generateRandomLineFromFile(FORMATTED_COURSE_FILE);
			pw.println(dataLine + "* " + emitPersonId() + "* " + buildingLetter + emitRoomNumber() + "* "
					+ emitBookIsbn(BOOK_ISBN_FILE) + "* ");
		}
		pw.close();
	}

	public static void makeStudentFile(int numberOfItems, String outputFileName) {
		PrintWriter pw = openFile(outputFileName);
		for (int i = 0; i < numberOfItems; i++) {
			pw.println(spew(Categories.FIRST, Categories.LAST, Categories.ID, Categories.PHONE, Categories.MAJOR,
					Categories.COURSES_TO_TAKE, Categories.COURSES_TAKING, Categories.COURSES_TAKEN));
		}
		pw.close();
	}

	public static void makeTextbookFile(int numberOfItems, String outputFileName) {
		PrintWriter pw = openFile(outputFileName);
		for (int i = 0; i < numberOfItems; i++) {
			pw.println(spew(Categories.BOOK_TITLE, Categories.FIRST, Categories.LAST, Categories.BOOK_ISBN,
					Categories.PRICE));
			// pw.println(String.valueOf(generateDoubleInRange(.01, 200.00)) + "*");
		}
		pw.close();
	}

	public static void makeFacultyFile(int numberOfItems, String outputFileName) {
		PrintWriter pw = openFile(outputFileName);
		for (int i = 0; i < numberOfItems; i++) {
			pw.println(spew(Categories.FIRST, Categories.LAST, Categories.ID, Categories.MAJOR,
					Categories.COURSES_TAUGHT, Categories.SALARY));
			// pw.println(String.valueOf(generateDoubleInRange(10000.00, 100000.00)) + "*");

		}
		pw.close();
	}

	public static void makeClassroomFile(int numberOfItems, String outputFileName) {
		PrintWriter pw = openFile(outputFileName);
		String building = "";
		char buildingLetter = ' ';
		String computers = "";
		String seats = "";
		int numComputers = 0;
		int numSeats = 0;

		for (int i = 0; i < numberOfItems; i++) {
			building = spew(Categories.BUILDING_NAME);
			buildingLetter = building.charAt(0);
			computers = emitNumberOfSeatsOrComputers();
			seats = emitNumberOfSeatsOrComputers();

			numComputers = Integer.parseInt(computers);
			numSeats = Integer.parseInt(seats);
			while (numComputers - 1 > numSeats) {
				numComputers--;
			}
			computers = String.valueOf(numComputers);
			pw.println(buildingLetter + spew(Categories.ROOM_NUMBER) + building + seats + "*" + computers + "*"
					+ spew(Categories.PROJECTOR_OR_NOT));
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

	public static String emitBuilding() {
		Random rand = new Random();
		Buildings[] buildings = Buildings.values();
		String[] buildingList = new String[buildings.length];
		for (int i = 0; i < buildings.length; i++) {
			buildingList[i] = String.valueOf(buildings[i]);
		}
		int randomBuildingValue = rand.nextInt(buildingList.length);
		return buildingList[randomBuildingValue];
	}

	public static String emitRoomNumber() {
		return String.valueOf(room++);
	}

	public static String emitNumberOfSeatsOrComputers() {
		Random rand = new Random();
		return String.valueOf(MIN_SEATS_COMPUTERS + rand.nextInt((MAX_SEATS_COMPUTERS - MIN_SEATS_COMPUTERS) + 1));
	}

	public static String emitProjectorOrNot() {
		Random rand = new Random();
		return String.valueOf(rand.nextBoolean());
	}

	public static String emitSalary() {
		return String.valueOf(generateDoubleInRange(10000.00, 100000.00));
	}

	public static String emitPrice() {
		return String.valueOf(generateDoubleInRange(.01, 200.00));
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

	public static String emitMajor(String filename) {
		StringBag majorBag = new StringBag(filename);
		return majorBag.emitString();
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

		String coursesTaking = "";
		String course = "";
		int randomNumberOfCourses = (1 + new Random().nextInt(numberOfCourses + 1));
		for (int i = 0; i < randomNumberOfCourses; i++) {
			do {
				course = majorBag.emitString();
			} while (!(course.length() == 6 && Character.isDigit(course.charAt(3))
					&& Character.isDigit(course.charAt(4)) && Character.isDigit(course.charAt(5))));
			coursesTaking += course + ",";
		}

		return coursesTaking;
	}

	public static String emitCourses_Taking(int numberOfCourses, String fileName) {
		Random rand = new Random();
		StringBag majorBag = new StringBag(fileName);

		String coursesTaking = "";
		String course = "";
		int randomNumberOfCourses = (1 + new Random().nextInt(numberOfCourses + 1));
		for (int i = 0; i < randomNumberOfCourses; i++) {
			do {
				course = majorBag.emitString();
			} while (!(course.length() == 6 && Character.isDigit(course.charAt(3))
					&& Character.isDigit(course.charAt(4)) && Character.isDigit(course.charAt(5))));
			coursesTaking += course + ",";
		}

		return coursesTaking;
	}

	public static String generateDoubleInRange(double minPrice, double maxPrice) {
		Random rand = new Random();
		double randomValue = minPrice + (maxPrice - minPrice) * rand.nextDouble();
		return String.format("%.2f", randomValue);
	}

	public static String emitCourses_Taken(int numberOfCourses, String fileName) {
		Random rand = new Random();
		int randomNumberOfCourses = (1 + new Random().nextInt(numberOfCourses + 1));
		String[] grades = { "A", "B+", "B", "C+", "C", "D+", "D", "F" };
		StringBag majorBag = new StringBag(fileName);
		String coursesTaken = "";
		String course = "";
		int location = 0;
		double gpa = 0.0;
		int totalCredits = 0;
		for (int i = 0; i < randomNumberOfCourses; i++) {
			do {
				course = majorBag.emitString();
			} while (!(course.length() == 6 && Character.isDigit(course.charAt(3))
					&& Character.isDigit(course.charAt(4)) && Character.isDigit(course.charAt(5))));
			for (int j = 0; j < majorBag.getNElems(); j++) {
				if (majorBag.emitStringAt(j).equals(course)) {
					location = j;
				}
			}
			String grade = grades[(rand.nextInt(grades.length))];
			String creditsForCourse = majorBag.emitStringAt(location + 1);
			if (creditsForCourse == null) {
				creditsForCourse = "0.0";
			}
			coursesTaken += majorBag.emitStringAt(location) + "," + grade + ",";
			double credits = Double.parseDouble(creditsForCourse);
			if (grade.equals("A")) {
				gpa += (4.0 * credits);
				totalCredits += credits;
			} else if (grade.equals("B+")) {
				gpa += (3.5 * credits);
				totalCredits += credits;
			} else if (grade.equals("B")) {
				gpa += (3.0 * credits);
				totalCredits += credits;
			} else if (grade.equals("C+")) {
				gpa += (2.5 * credits);
				totalCredits += credits;
			} else if (grade.equals("C")) {
				gpa += (2.0 * credits);
				totalCredits += credits;
			} else if (grade.equals("D+")) {
				gpa += (1.5 * credits);
				totalCredits += credits;
			} else if (grade.equals("D")) {
				gpa += (1.0 * credits);
				totalCredits += credits;
			} else {
				gpa += 0.0;
			}
		}
		gpa = gpa / totalCredits;
		if (gpa > 0.0) {
			return coursesTaken + '*' + String.format("%.2f", gpa);
		} else {
			return coursesTaken + '*' + "0.0";
		}
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
