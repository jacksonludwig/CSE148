package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileSaver implements Serializable {

	public static void saveAllBags(PersonBag personBag, ClassroomBag classBag, TextbookBag textBag, CourseBag courseBag,
			String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(personBag);
			oos.writeObject(classBag);
			oos.writeObject(textBag);
			oos.writeObject(courseBag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void savePersons(PersonBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void saveCourses(CourseBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void saveTextbooks(TextbookBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void saveClassrooms(ClassroomBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void saveCollege(College college, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(college);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
