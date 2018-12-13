package p2;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("John", 3.5);
		System.out.println(s1.getId());
		
		Student s2 = new Student("Jane", 3.5);
		System.out.println(s2.getId());
		
		Student s3 = new Student(s1);
		System.out.println(s3.getId());
		
		Student s4 = Student.deepCopy(s1);
		System.out.println(s4.getId());
		
		
//		
//		Student s2 = new Student(s1);
//		Student s3 = Student.deepCopy(s1);
//		Student s4 = Student.shallowCopy(s1);
////		System.out.println(s1.equals(s2));
////		System.out.println(s1 == s2);
//		String name1 = "John";
//		String name2 = "Doe";
//		System.out.println(name1.equals(name2));
	}

}
