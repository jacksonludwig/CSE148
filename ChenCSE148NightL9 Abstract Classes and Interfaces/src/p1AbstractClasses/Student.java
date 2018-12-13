package p1AbstractClasses;
// Abstract classes have AT LEAST 1 abstract method. (classes without abstract classes are "concrete").
// Abstract methods are methods without a body.
// You cannot instantiate an abstract class; in other words: Abstract classes CANNOT make objects.
public abstract class Student {
	private String name;
	private double gpa;

	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public abstract void setName(String name);

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}

}
