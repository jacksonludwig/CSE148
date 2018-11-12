package model;

public class CourseNumberAndGrade {
	private String courseNumber;
	private String grade;

	public CourseNumberAndGrade(String courseNumber, String grade) {
		super();
		this.courseNumber = courseNumber;
		this.grade = grade;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "CourseNumberAndGrade [courseNumber=" + courseNumber + ", grade=" + grade + "]";
	}

}
