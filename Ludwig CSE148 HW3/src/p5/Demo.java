package p5;

public class Demo {
	public static void main(String[] args) {
		Student s1 = new Student("John","123456789",3.2);
		
		Student s2 = new Student(s1);
		s1.setName("Jack");
		
		Student s3 = s1.shallowCopy(s1);
		
		System.out.println(s1 + " " + s2 + " " + s3);
	}
	
}
