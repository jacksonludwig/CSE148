package p4;

public class Student {
	private String name;
	private double gpa;
	
	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}
	
	public Student () {
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
	}
	
	public void curveGPA(double curveAmount) {
		gpa = gpa + .2;
	}
}
