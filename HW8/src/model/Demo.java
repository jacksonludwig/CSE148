package model;

public class Demo {

	public static void main(String[] args) {
		Student p1 = new Student("outputData/Students.txt");
		Faculty p2 = new Faculty("outputData/Faculty.txt");
		Course c1 = new Course("outputData/CourseInventoryReformatted.txt");
		Classroom b1 = new Classroom("outputData/Classroom.txt");
		Textbook t1 = new Textbook("outputData/Textbooks.txt");
		System.out.println(p1 + "\n" + p2);
		System.out.println(c1);
		System.out.println(b1);
		System.out.println(t1);
	}

}
