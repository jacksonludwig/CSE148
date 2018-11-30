package p1TextFileGenerators;

public class DataImporter {
	// does not really apply with the way I did HW7... will have to remake it
	public DataImporter() {
		
	}
	
	public void importStudents(PersonBag bag, Student s) {
		bag.insert(s);
	}
	
	public void importFaculty(PersonBag bag, Faculty f) {
		bag.insert(f);
	}
	
	public void importCourses(CourseBag bag, Course c) {
		bag.insert(c);
	}
	
	public void importTextbooks(TextbookBag bag, Textbook t) {
		bag.insert(t);
	}
	
	public void importClassrooms(ClassroomBag bag, Classroom c) {
		bag.insert(c);
	}
	
	
}
