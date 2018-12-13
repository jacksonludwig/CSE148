package p6;

public class Demo {

	public static void main(String[] args) {
		Student[] student = { new Student("John", "123", 2.3), new Student("Jane", "321", 2.6),
				new Student("Jack", "657", 3.0), new Student("Jim", "999", 4.0), new Student("Jill", "777", 1.2) };

		Faculty f1 = new Faculty("Chen", "123", 1000000);
		Faculty f2 = new Faculty("Chen", "123", 1000000);
		
		Course c1 = new Course("Intro To Compsci", "CSE118", student, f1);

		Course c2 = new Course("Object-Oriented Programming", "CSE148", student, f2);
		
		c1.getFacultyMember().setName("notChen");
		
		System.out.println(c1 + "\n" + c2);

	}

}
