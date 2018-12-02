package model;

import java.util.ArrayList;

public class Faculty extends Person {
	private String department;
	private ArrayList<String> coursesTeaching;

	public Faculty(String filename) {
		super(filename);
		String dataLine = super.getDataLine();
		department = getDepartmentFromFile(dataLine);
		coursesTeaching = getCoursesTeachingFromFile(dataLine);
	}

	public Faculty(String first, String last, String filename) {
		super(first, last, filename);
		String dataLine = super.getDataLine();
		department = getDepartmentFromFile(dataLine);
		coursesTeaching = getCoursesTeachingFromFile(dataLine);
	}

	public String getDepartmentFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String department = "";
		while (sectionCount < 3) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			department += line.charAt(count);
			count++;
		}
		return department;
	}

	public ArrayList<String> getCoursesTeachingFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		ArrayList<String> courses = new ArrayList<>();
		String course = "";
		while (sectionCount < 4) {
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public ArrayList<String> getCoursesTeaching() {
		return coursesTeaching;
	}

	public void setCoursesTeaching(ArrayList<String> coursesTeaching) {
		this.coursesTeaching = coursesTeaching;
	}

	@Override
	public String toString() {
		return "Faculty [toString()=" + super.toString() + ", department=" + department + ", coursesTeaching="
				+ coursesTeaching + "]";
	}

}
