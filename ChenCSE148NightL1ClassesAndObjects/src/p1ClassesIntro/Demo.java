package p1ClassesIntro;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student();
	/*
		s1.setName("John");
		s1.setAge(19);
		s1.setGpa(3.1);
		s1.setId("12345678");
	*/
	//	s1.setAll("John", "12345678", 10, 1.1);
		System.out.println(s1);
		
		
		Student s2 = new Student("Jane","3333",20,4.0);
		System.out.println(s2);
		
	/*	
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getGpa());
		System.out.println(s1.getId());
		
		s1.driveToSchool();
		s1.takeTheBus();
		
		Student s2 = new Student();
		
		s2.driveToSchool();
		s2.takeTheBus();
	*/
	}

}
