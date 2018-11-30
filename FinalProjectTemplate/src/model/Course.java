package model;

public class Course {
	private String courseNumber;
	private String courseTitle;

	public Course(String courseNumber, String courseTitle) {
		super();
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	@Override
	public String toString() {
		return "courseNumber=" + courseNumber + ", courseTitle=" + courseTitle;
	}

}
