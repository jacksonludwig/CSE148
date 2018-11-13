package p1ObjectSerialization;

import java.io.Serializable;

public class Student extends Person implements Serializable{
	private double gpa;

	public Student(String name, double gpa) {
		super(name);
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return super.toString() + ", GPA= " + gpa;
	}
	
}
