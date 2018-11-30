package model;

import java.util.ArrayList;

public class Student extends Person {
	private String phoneNumber;
	private String major;
	private ArrayList<String> coursesToTake;
	private ArrayList<String> coursesTaking;
	private ArrayList<String> coursesTaken;
	private double gpa;

	public Student(String filename) {
		super(filename);
		String dataLine = super.getDataLine();
		phoneNumber = getPhoneNumberFromFile(dataLine);
		major = getMajorFromFile(dataLine);
		coursesToTake = getCoursesToTakeFromFile(dataLine);
		coursesTaking = getCoursesTakingFromFile(dataLine);
		coursesTaken = getCoursesTakenFromFile(dataLine);
		gpa = getGpaFromFile(dataLine);
	}

	public Student(String first, String last, String filename) {
		super(first, last, filename);
		String dataLine = super.getDataLine();
		phoneNumber = getPhoneNumberFromFile(dataLine);
		major = getMajorFromFile(dataLine);
		coursesToTake = getCoursesToTakeFromFile(dataLine);
		coursesTaking = getCoursesTakingFromFile(dataLine);
		coursesTaken = getCoursesTakenFromFile(dataLine);
		gpa = getGpaFromFile(dataLine);
	}

	public String getPhoneNumberFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String phone = "";
		while (sectionCount < 3) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			phone += line.charAt(count);
			count++;
		}
		return phone;
	}

	public String getMajorFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String major = "";
		while (sectionCount < 4) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			major += line.charAt(count);
			count++;
		}
		return major;
	}

	public ArrayList<String> getCoursesToTakeFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		ArrayList<String> courses = new ArrayList<>();
		String course = "";
		while (sectionCount < 5) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}

		while (line.charAt(count) != '*') {
			course += line.charAt(count);
			if (line.charAt(count) == ',') {
				courses.add(course.substring(0, course.length() - 1));
				course = "";
			}
			count++;
		}
		return courses;
	}

	public ArrayList<String> getCoursesTakingFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		ArrayList<String> courses = new ArrayList<>();
		String course = "";
		while (sectionCount < 6) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}

		while (line.charAt(count) != '*') {
			course += line.charAt(count);
			if (line.charAt(count) == ',') {
				courses.add(course.substring(0, course.length() - 1));
				course = "";
			}
			count++;
		}
		return courses;
	}

	public ArrayList<String> getCoursesTakenFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		ArrayList<String> courses = new ArrayList<>();
		String course = "";
		while (sectionCount < 7) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}

		int commaCount = 0;
		while (line.charAt(count) != '*') {
			course += line.charAt(count);
			if (line.charAt(count) == ',') {
				commaCount++;
				if (commaCount % 2 == 0) {
					courses.add(course.substring(0, course.length() - 1));
					course = "";
				}
			}
			count++;
		}
		return courses;
	}

	public double getGpaFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String gpa = "";
		while (sectionCount < 8) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			gpa += line.charAt(count);
			count++;
		}
		return Double.parseDouble(gpa);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public ArrayList<String> getCoursesToTake() {
		return coursesToTake;
	}

	public void setCoursesToTake(ArrayList<String> coursesToTake) {
		this.coursesToTake = coursesToTake;
	}

	public ArrayList<String> getCoursesTaking() {
		return coursesTaking;
	}

	public void setCoursesTaking(ArrayList<String> coursesTaking) {
		this.coursesTaking = coursesTaking;
	}

	public ArrayList<String> getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(ArrayList<String> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public double getGpa() {
		return gpa;
	}

//	public void setGpa(double gpa) {
//		this.gpa = gpa;
//	}

	@Override
	public String toString() {
		return "Student [toString()=" + super.toString() + ", phoneNumber=" + phoneNumber + ", major=" + major
				+ ", coursesToTake=" + coursesToTake + ", coursesTaking=" + coursesTaking + ", coursesTaken="
				+ coursesTaken + ", gpa=" + gpa + "]";
	}

}
