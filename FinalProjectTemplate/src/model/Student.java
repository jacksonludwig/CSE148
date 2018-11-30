package model;

public class Student extends Person {
	private double gpa;
	
	public Student(String name) {
		super(name);
		gpa = 0.0;
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
