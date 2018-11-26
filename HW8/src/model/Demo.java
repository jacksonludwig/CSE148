package model;

public class Demo {

	public static void main(String[] args) {
		Student p1 = new Student("outputData/Students.txt");
		Faculty p2 = new Faculty("outputData/Faculty.txt");
		System.out.println(p1 + "\n" + p2);
		System.out.println(Utilities.formatRandomCourse("outputData/Course_Inventory.txt"));
	}

}
