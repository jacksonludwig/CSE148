package p9;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
	private String firstName;
	private String lastName;
	private String id;
	private ArrayList<String> classes = new ArrayList<String>();
	private double gpa;
	
	public Student(String firstName, String lastName, String id, ArrayList<String> classes, int gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.classes = classes;
		this.gpa = gpa;
	}

	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<String> classes) {
		this.classes = classes;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", classes=" + classes
				+ ", gpa=" + gpa;
	}
	
}
