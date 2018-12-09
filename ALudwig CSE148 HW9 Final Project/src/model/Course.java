package model;

import java.io.Serializable;

public class Course implements Serializable {
	private String courseTitleShort;
	private String courseTitleLong;
	private String courseDescription;
	private double numberOfCredits;
	private String facultyID;
	private String textbookISBN;
	private String classroom;

	public Course(String dataLine) {
		courseTitleShort = generateCourseTitleShortFromFile(dataLine);
		courseTitleLong = generateCourseTitleLongFromFile(dataLine);
		courseDescription = generateCourseDescriptionFromFile(dataLine);
		numberOfCredits = generateNumberOfCreditsFromFile(dataLine);
		facultyID = generateFacultyIdFromFile(dataLine);
		textbookISBN = generateTextbookISBNFromFile(dataLine);
		classroom = generateClassroomFromFile(dataLine);
	}

	public Course(String courseShort, String courseLong, String courseDesc, double numberOfCredits, String id,
			String isbn, String classroom) {
		courseTitleShort = courseShort;
		courseTitleLong = courseLong;
		courseDescription = courseDesc;
		this.numberOfCredits = numberOfCredits;
		facultyID = id;
		textbookISBN = isbn;
		this.classroom = classroom;
	}

	public String generateCourseTitleShortFromFile(String line) {
		int count = 0;
		String title = "";
		while (line.charAt(count) != '*') {
			title += line.charAt(count);
			count++;
		}
		return title;
	}

	public String generateCourseTitleLongFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String title = "";
		while (sectionCount < 1) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		count++;
		while (line.charAt(count) != '*') {
			title += line.charAt(count);
			count++;
		}
		return title;
	}

	public String generateCourseDescriptionFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String description = "";
		while (sectionCount < 2) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		count++;
		while (line.charAt(count) != '*') {
			description += line.charAt(count);
			count++;
		}
		return description;
	}

	public double generateNumberOfCreditsFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String description = "";
		while (sectionCount < 3) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		count++;
		while (line.charAt(count) != '*') {
			description += line.charAt(count);
			count++;
		}
		return Double.parseDouble(description);
	}

	public String generateFacultyIdFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String description = "";
		while (sectionCount < 4) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		count++;
		while (line.charAt(count) != '*') {
			description += line.charAt(count);
			count++;
		}
		return description;
	}

	public String generateClassroomFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String description = "";
		while (sectionCount < 5) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		count++;
		while (line.charAt(count) != '*') {
			description += line.charAt(count);
			count++;
		}
		return description;
	}

	public String generateTextbookISBNFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String description = "";
		while (sectionCount < 6) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		count++;
		while (line.charAt(count) != '*') {
			description += line.charAt(count);
			count++;
		}
		return description;
	}

	public String getCourseTitleShort() {
		return courseTitleShort;
	}

	public void setCourseTitleShort(String courseTitleShort) {
		this.courseTitleShort = courseTitleShort;
	}

	public String getCourseTitleLong() {
		return courseTitleLong;
	}

	public void setCourseTitleLong(String courseTitleLong) {
		this.courseTitleLong = courseTitleLong;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public double getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(double numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}

	public String getTextbookISBN() {
		return textbookISBN;
	}

	public void setTextbookISBN(String textbookISBN) {
		this.textbookISBN = textbookISBN;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Course [courseTitleShort=" + courseTitleShort + ", courseTitleLong=" + courseTitleLong
				+ ", courseDescription=" + courseDescription + ", facultyID=" + facultyID + ", textbookISBN="
				+ textbookISBN + ", classroom=" + classroom + "]";
	}

}
