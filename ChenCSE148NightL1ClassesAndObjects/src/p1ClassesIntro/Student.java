package p1ClassesIntro;

// classes have a name, state (instance variables), and methods (constructor, toString, set & gets. 
// the "public" keyword means the whole world can access, an absence of a "public" or "private"
// means all the programs inside the package can access. "private" means only this local
// class alone can access this class. Protected allows everything in the program can be accessed
// by things in the package AND subclasses can access.
public class Student {
	
	// fields, instance variables, properties
	// attributes.
	// They describe the state of the object
	private String name;
	private int age;
	private String id;
	private double gpa;
	
	public Student() {
		name = "John";
		id = "2222";
		age = 18;
		gpa = 2.0;
	}
	
	public Student(String name, String id, int age, double gpa) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.gpa = gpa;
	}
	// 4 setters
	public void setAll(String name, String id, int age, double gpa) {
		this.gpa = gpa;
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public void setName(String newName) {
		name = newName;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public void setId(String newId) {
		id = newId;
	}
	
	public void setGpa(double newGpa) {
		gpa = newGpa;
	}
	
	// 4 getters
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getId() {
		return id;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public String toString() {
		return "Name =" + name + "\n" + "ID= " + id + "\n" 
				+ "Age= " + age + "\n" + "GPA=" + gpa + "\n";
	}
	
	// behavior, (methods -- what can the variables do)
	public void driveToSchool() {
		System.out.println("Drive your car to school.");
	}
	
	public void takeTheBus() {
		System.out.println("Take the bus to school.");
	}
}
