package p1TextFileGenerators;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileSaver implements Serializable {
	
	public FileSaver() {
		
	}
	
	public void savePersons(PersonBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void saveCourses(CourseBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void saveTextbooks(TextbookBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void saveClassrooms(ClassroomBag bag, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
