package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class DataImporter implements Serializable{
	public static void importStudents(PersonBag bag) {
		File file = new File("outputData/Students.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			String dataLine = scanner.nextLine();
			Student s = new Student(dataLine);
			bag.insert(s);
		}
	}
	
	public static void importFaculty(PersonBag bag) {
		File file = new File("outputData/Faculty.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			String dataLine = scanner.nextLine();
			Faculty f = new Faculty(dataLine);
			bag.insert(f);
		}
	}
	
	public static void importCourses(CourseBag bag) {
		File file = new File("outputData/Courses.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			String dataLine = scanner.nextLine();
			Course c = new Course(dataLine);
			bag.insert(c);
		}
	}
	
	public static void importTextbooks(TextbookBag bag) {
		File file = new File("outputData/Textbooks.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			String dataLine = scanner.nextLine();
			Textbook t = new Textbook(dataLine);
			bag.insert(t);
		}
	}
	
	public static void importClassrooms(ClassroomBag bag) {
		File file = new File("outputData/Classroom.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			String dataLine = scanner.nextLine();
			Classroom c = new Classroom(dataLine);
			bag.insert(c);
		}
	}
}
