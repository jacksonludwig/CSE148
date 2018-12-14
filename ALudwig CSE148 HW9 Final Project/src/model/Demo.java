package model;

import utilities.Utilities;

// Test/initial generation file

public class Demo {

	public static void main(String[] args) {
		String dataLine1 = Utilities.generateRandomLineFromFile("outputData/Students.txt");
		Student p1 = new Student(dataLine1);
		String dataLine2 = Utilities.generateRandomLineFromFile("outputData/Faculty.txt");
		Faculty p2 = new Faculty(dataLine2);
		String dataLine3 = Utilities.generateRandomLineFromFile("outputData/Courses.txt");
		Course c1 = new Course(dataLine3);
		String dataLine4 = Utilities.generateRandomLineFromFile("outputData/Classroom.txt");
		Classroom b1 = new Classroom(dataLine4);
		String dataLine5 = Utilities.generateRandomLineFromFile("outputData/Textbooks.txt");
		Textbook t1 = new Textbook(dataLine5);
		System.out.println(p1 + "\n" + p2);
		System.out.println(c1);
		System.out.println(b1);
		System.out.println(t1);

		PersonBag people = new PersonBag(4000);
		CourseBag courseImport = new CourseBag(4000);
		ClassroomBag classImport = new ClassroomBag(2000);
		TextbookBag textImport = new TextbookBag(2000);

		DataImporter.importStudents(people, "outputData/Students.txt");
		DataImporter.importFaculty(people, "outputData/Faculty.txt");
		DataImporter.importCourses(courseImport, "outputData/Courses.txt");
		DataImporter.importClassrooms(classImport, "outputData/Classroom.txt");
		DataImporter.importTextbooks(textImport, "outputData/Textbooks.txt");

//		College college = new College(people, classImport, textImport, courseImport);

//		FileSaver.saveClassrooms(classImport, "savedFiles/classrooms.dat");
//		FileSaver.saveCourses(courseImport, "savedFiles/courses.dat");
//		FileSaver.saveTextbooks(textImport, "savedFiles/textbooks.dat");
//		FileSaver.savePersons(people, "savedFiles/persons.dat");
//		FileSaver.saveCollege(college, "savedFiles/college.dat");

		FileSaver.saveAllBags(people, classImport, textImport, courseImport, "savedFiles/allBags.dat");
	}

}
