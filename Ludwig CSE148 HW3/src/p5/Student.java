package p5;

public class Student {
	private String name;
	private String id;
	private double gpa;

	public Student(String name, String id, double gpa) {
		super();
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}

	public Student(Student s) {
		name = s.getName();
		id = s.getId();
		gpa = s.getGpa();
	}

	public Student deepCopy(Student student) {
		return new Student(student.getName(), student.getId(), student.getGpa());
	}
	
	public Student shallowCopy(Student student) {
		return student;
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
