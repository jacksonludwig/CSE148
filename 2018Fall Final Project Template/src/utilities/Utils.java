package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.ClassroomBag;
import model.College;
import model.CourseBag;
import model.PersonBag;
import model.TextbookBag;

public class Utils {
	public static void load(College college) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("binaryData/allBags.dat");
		ObjectInputStream oos = new ObjectInputStream(fis);
		
		PersonBag personBag = (PersonBag) (oos.readObject());
		college.setPersonBag(personBag);
		
		ClassroomBag classroomBag = (ClassroomBag) (oos.readObject());
		college.setClassroomBag(classroomBag);
		
		TextbookBag textbookBag = (TextbookBag) (oos.readObject());
		college.setTextbookBag(textbookBag);
		
		CourseBag courseBag = (CourseBag) (oos.readObject());
		college.setCourseBag(courseBag);
		
		oos.close();
	}
}
