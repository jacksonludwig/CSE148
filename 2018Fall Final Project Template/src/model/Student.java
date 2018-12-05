package model;

import java.io.Serializable;

public class Student extends Person implements Serializable{
	private double gpa;

	public Student(String name) {
		super(name);
		this.gpa = 0.0;
	}

	public double getGpa() {
		return gpa;
	}

	void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return super.toString() + ", gpa=" + gpa;
	}
	
	
}
