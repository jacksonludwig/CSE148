package p6;

import java.util.Arrays;

public class Course {
	private String title;
	private String courseNumber;
	private Student[] students;
	private Faculty facultyMember;

	public Course(String title, String courseNumber, Student[] students, Faculty facultyMember) {
		super();
		this.title = title;
		this.courseNumber = courseNumber;
		this.students = students;
		this.facultyMember = facultyMember;
	}

	public Course() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Faculty getFacultyMember() {
		return facultyMember;
	}

	public void setFacultyMember(Faculty facultyMember) {
		this.facultyMember = facultyMember;
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", courseNumber=" + courseNumber + ", students=" + Arrays.toString(students)
				+ ", facultyMember=" + facultyMember + "]";
	}

}
