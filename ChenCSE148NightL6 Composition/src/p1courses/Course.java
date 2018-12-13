package p1courses;

import java.util.Arrays;

public class Course {
	private String courseNumber;
	private String courseName;
	private Textbook textbook;
	private Instructor instructor;
	private Student[] students;

	public Course(String courseNumber, String courseName, Textbook textbook, Instructor instructor,
			Student[] students) {
		super();
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.textbook = textbook;
		this.instructor = instructor;
		this.students = students;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Textbook getTextbook() {
		return new Textbook(textbook);
	}

	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}

	public Instructor getInstructor() {
		return new Instructor(instructor);
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Student[] getStudents() {
		return Arrays.copyOf(students, students.length);
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course Number=" + courseNumber + "\n\tCourse Name=" + courseName + "\n\ttextbook=" + textbook
				+ "\n\tInstructor=" + instructor + "\n\tStudents=" + Arrays.toString(students);
	}

}
