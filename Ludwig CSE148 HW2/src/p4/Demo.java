package p4;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student();
		
		s1.setName("John");
		s1.setGpa(3.2);
		
		System.out.println("Original: " + s1.getGpa());
		s1.curveGPA(.2);
		System.out.println("New: " + String.format("%.2f", s1.getGpa()));

	}

}
