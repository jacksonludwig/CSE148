package model;

public class DataImporter {
	public static void importStudents(PersonBag bag, Student s) {
		bag.insert(s);
	}
	
	public static void importFaculty(PersonBag bag, Faculty f) {
		bag.insert(f);
	}
	
	public static void importCourses(CourseBag bag, Course c) {
		bag.insert(c);
	}
	
	public static void importTextbooks(TextbookBag bag, Textbook t) {
		bag.insert(t);
	}
	
	public static void importClassrooms(ClassroomBag bag, Classroom c) {
		bag.insert(c);
	}
}
