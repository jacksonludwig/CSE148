package p1courses;

public class Demo {

	public static void main(String[] args) {
		Textbook textbook1 = new Textbook("Java", "111-222", 99.99, "Chen");
		Instructor instructor1 = new Instructor("Chen", "Professor", 10000.00);
		Student[] students = {	new Student("John", "111", 4.0),
								new Student("Jane", "222", 3.9)};
		
		Course c1 = new Course("CSE148", "OOP", textbook1, instructor1, students);
		Instructor i1 = c1.getInstructor();
		i1 = instructor1;
		System.out.println(instructor1 == i1);
		i1.setName("Smith");	// Smith
		System.out.println(i1.getName()); //Smith
		System.out.println(c1.getInstructor().getName()); // Chen
		
		Textbook t1 = c1.getTextbook();
		t1.setTitle("HTML");
		System.out.println(t1.getTitle()); // HTML
		System.out.println(c1.getTextbook().getTitle()); //Java
	}

}
