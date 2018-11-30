package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.ClassroomBag;
import model.College;
import model.CourseBag;
import model.PersonBag;
import model.TextbookBag;

// saves, imports, exports should go in util files

public class Utilities {
	public static void load(College college) {
		FileInputStream fis = null;
		// must be loaded in the same order it was saved, if everything is in the same
		// file
		PersonBag personBag = college.getPersonBag();
		ClassroomBag classroomBag = college.getClassroomBag();
		TextbookBag textbookBag = college.getTextbookBag();
		CourseBag courseBag = college.getCourseBag();
		try {
			fis = new FileInputStream("binaryData/allBags.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			personBag = (PersonBag) ois.readObject();
			classroomBag = (ClassroomBag) ois.readObject();
			textbookBag = (TextbookBag) ois.readObject();
			courseBag = (CourseBag) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
