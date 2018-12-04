package p1TextFileGenerators;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo {

	private static final int NUMBER_OF_TEXTBOOKS = 250;
	private static final int NUMBER_OF_CLASSROOMS = 100;
	private static final int NUMBER_OF_COURSES = 300;
	private static final int NUMBER_OF_FACULTY = 200;
	private static final int NUMBER_OF_STUDENTS= 2000;
	
	public static void main(String[] args) throws IOException {
//		printTextbooksToFile();
//		printClassroomsToFile();
//		printCoursesToFile();
//		printFacultyToFile();
		printStudentsToFile();
		Student s1 = new Student();
		System.out.println(s1.calculateGpa());
	}

	public static void printTextbooksToFile() throws IOException {
		FileWriter fw = new FileWriter("Textbooks.txt", false);
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < NUMBER_OF_TEXTBOOKS; i++) {
			Textbook textbook = new Textbook();
			pw.print(textbook + "\n");
		}
		pw.close();
	}
	
	public static void printClassroomsToFile() throws IOException {
		FileWriter fw = new FileWriter("Classrooms.txt", false);
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < NUMBER_OF_CLASSROOMS; i++) {
			Classroom classroom = new Classroom();
			pw.print(classroom + "\n");
		}
		pw.close();
	}
	
	public static void printCoursesToFile() throws IOException {
		FileWriter fw = new FileWriter("Courses.txt", false);
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < NUMBER_OF_COURSES; i++) {
			Course course = new Course();
			pw.print(course + "\n");
		}
		pw.close();
	}
	
	public static void printFacultyToFile() throws IOException {
		FileWriter fw = new FileWriter("Faculty.txt", false);
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < NUMBER_OF_FACULTY; i++) {
			Faculty faculty = new Faculty();
			pw.print(faculty + "\n");
		}
		pw.close();
	}

	public static void printStudentsToFile() throws IOException {
		FileWriter fw = new FileWriter("Students.txt", false);
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
			Student student = new Student();
			pw.print(student + "\n");
		}
		pw.close();
	}
}
