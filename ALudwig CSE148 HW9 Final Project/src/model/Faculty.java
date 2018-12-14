package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Faculty extends Person implements Serializable {
	private String department;
	private String phoneNumber;
	private ArrayList<String> coursesTeaching;
	private double salary;

	public Faculty(String dataLine) {
		super(dataLine);
		department = getDepartmentFromFile(dataLine);
		phoneNumber = getPhoneNumberFromFile(dataLine);
		coursesTeaching = getCoursesTeachingFromFile(dataLine);
		salary = Double.parseDouble(getSalaryFromFile(dataLine));
	}

	public Faculty(String first, String last, String department, String phoneNumber, ArrayList<String> coursesTeaching,
			String salary) {
		super(first, last);
		this.department = department;
		this.phoneNumber = phoneNumber;
		this.coursesTeaching = coursesTeaching;
		try {
			this.salary = Double.parseDouble(salary);
		} catch (NumberFormatException e) {
			this.salary = 50000;
		}
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
	
	public String getDepartmentFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String department = "";
		while (sectionCount < 4) {
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

	public String getSalaryFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String money = "";
		while (sectionCount < 6) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			money += line.charAt(count);
			count++;
		}
		return money;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Faculty [toString()=" + super.toString() + ", phone=" + phoneNumber + ", department=" + department  + ", coursesTeaching="
				+ coursesTeaching + ", salary=" + salary + "]";
	}
}
