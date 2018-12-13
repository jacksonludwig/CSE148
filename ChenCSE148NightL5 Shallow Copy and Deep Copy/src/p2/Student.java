package p2;

public class Student {
	private String name;
	private String id;
	private double gpa;
	
	private static int idNumber = 1;

	public Student(String name, double gpa) {
		this.name = name;
		this.id = String.valueOf(idNumber++);
		this.gpa = gpa;
	}

	public Student() {
		super();
	}

	public Student(Student s) {
		this(s.name, s.gpa);
	}

	public boolean equals(Student s) {
		if (this.name.equals(s.name) && this.id.equals(s.id) && this.gpa == s.gpa) {
			return true;
		} else {
			return false;
		}
	}

	
	public static Student shallowCopy(Student s) {
		return s;
	}

	public static Student deepCopy(Student s) {
		return new Student(s);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", gpa=" + gpa + "]";
	}

}
