package p1;

public class Instructor extends Person{
	private double salary;

	public Instructor(String name, String ssn, double salary) {
		super(name, ssn);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Instructor = " + super.toString() + ", salary= " + salary;
	}
	
	
	
	
}
