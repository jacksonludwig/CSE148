package p1TextFileGenerators;

import java.io.IOException;
import java.util.Random;

public class Student extends Person {
	private String phoneNumber;
	private String major;
	private String coursesToTake;
	private String coursesTaking;
	private String coursesTakenWithGrades;
	private String gpa;

	private String grades = "";

	private static final int MAX_NUM_TO_TAKE = 8;
	private static final int MAX_NUM_TAKING = 5;
	private static final int MAX_NUM_TAKEN_GRADE = 7;
	private static final int NUM_GRADES = 8;

	public Student() throws IOException {
		super();
		phoneNumber = Utilities.generatePhoneNumber();
		major = Utilities.generateMajor();
		coursesToTake = generateNumberOfCourses(MAX_NUM_TO_TAKE);
		coursesTaking = generateNumberOfCourses(MAX_NUM_TAKING);
		coursesTakenWithGrades = generateNumCrsWithGrades(MAX_NUM_TAKEN_GRADE);
		gpa = calculateGpa();
	}

	public String generateNumberOfCourses(int amount) throws IOException {
		Random rand = new Random();
		int randomValue = rand.nextInt(amount) + 1;
		String courses = "";
		for (int i = 0; i < randomValue; i++) {
			if (i == randomValue - 1) {
				courses += Utilities.getCourses() + " ";
			} else {
				courses += Utilities.getCourses() + ",";
			}
		}
		return courses;
	}

	public String generateNumCrsWithGrades(int amount) throws IOException {
		Random rand = new Random();
		int randomValue = rand.nextInt(amount + 1) + 1;
		String courses = "";
		for (int i = 0; i < randomValue; i++) {
			if (i == randomValue - 1) {
				courses += Utilities.getCourses() + "," + generateGrade();
			} else {
				courses += Utilities.getCourses() + "," + generateGrade() + ",";
			}
		}
		return courses;
	}

	public String generateGrade() {
		Random rand = new Random();
		int randomValue = rand.nextInt(NUM_GRADES);
		String grade = "";
		if (randomValue == 0) {
			grade = "A";
		} else if (randomValue == 1) {
			grade = "B+";
		} else if (randomValue == 2) {
			grade = "B";
		} else if (randomValue == 3) {
			grade = "C+";
		} else if (randomValue == 4) {
			grade = "C";
		} else if (randomValue == 5) {
			grade = "D+";
		} else if (randomValue == 6) {
			grade = "D";
		} else {
			grade = "F";
		}
		grades += grade;
		return grade;
	}

	public String calculateGpa() {
		double averageGrade = 0;
		int plusCount = 0;
		for (int i = 0; i < grades.length(); i++) {
			if (grades.charAt(i) == 'A') {
				averageGrade += 100;
			} else if (grades.charAt(i) == 'B' && i < grades.length() - 1 && grades.charAt(i + 1) == '+') {
				i++;
				plusCount++;
				averageGrade += 89;
			} else if (grades.charAt(i) == 'B') {
				averageGrade += 85;
			} else if (grades.charAt(i) == 'C' && i < grades.length() - 1 && grades.charAt(i + 1) == '+') {
				i++;
				plusCount++;
				averageGrade += 80;	
			} else if (grades.charAt(i) == 'C') {
				averageGrade += 75;
			} else if (grades.charAt(i) == 'D' && i < grades.length() - 1 && grades.charAt(i + 1) == '+') {
				i++;
				plusCount++;
				averageGrade += 70;
			} else if (grades.charAt(i) == 'D') {
				averageGrade += 65;
			} else {
				averageGrade += 55;
			}
		}
		
		averageGrade /= (grades.length() - plusCount);
		String gpaGrade = "";

		if (averageGrade >= 95) {
			gpaGrade = "4.0";
		} else if (averageGrade >= 88) {
			gpaGrade = "3.5";
		} else if (averageGrade >= 84) {
			gpaGrade = "3.0";
		} else if (averageGrade >= 78) {
			gpaGrade = "2.5";
		} else if (averageGrade >= 74) {
			gpaGrade = "2.0";
		} else if (averageGrade >= 65) {
			gpaGrade = "1.5";
		} else if (averageGrade < 65) {
			gpaGrade = "1.0";
		} else {
			gpaGrade = "<1.0";
		}
		return gpaGrade;
	}

	@Override
	public String toString() {
		return super.toString() + phoneNumber + " " + major + " " + coursesToTake + coursesTaking
				+ coursesTakenWithGrades + " " + gpa;
	}

}
