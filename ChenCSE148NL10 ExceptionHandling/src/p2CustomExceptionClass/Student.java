package p2CustomExceptionClass;

import java.util.Scanner;

public class Student {
	private String name;
	private double gpa;

	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
		checkGPAValidity(gpa);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
		checkGPAValidity(gpa);
	}

	public void checkGPAValidity(double gpa) {
		if (gpa > 4.0 || gpa < 0.0) {
			try {
				throw new InvalidGPAException("Invalid GPA Entered -- GPA Reset to 0.0");
			} catch (Exception e) {
				getNewGPA();
			}
		}
	}

	public double getNewGPA() {
		Scanner kboard = new Scanner(System.in);
		do {
			System.out.println("Enter a new GPA");
			gpa = kboard.nextDouble();
		} while (gpa > 4.0 || gpa < 0.0);
		return gpa;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}

}
