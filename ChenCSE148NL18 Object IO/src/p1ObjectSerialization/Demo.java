package p1ObjectSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

	// much more logical to save the write and read code for a separate class in
	// static methods.

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student s1 = new Student("john", 3.0);
		Student s2 = new Student("jane", 2.0);
		Student s3 = new Student("jake", 4.0);
		Student s4 = new Student("luke", 2.6);
		Student s5 = new Student("tim", 3.1);
		Student s6 = new Student("frank", 2.7);
		Student s7 = new Student("alan", 1.5);
		Student s8 = new Student("gary", 1.0);

		Student[] arr = { s1, s2, s3 }; // array object

		PersonBag theBag = new PersonBag(10);
		theBag.insert(s1);
		theBag.insert(s2);
		theBag.insert(s3);
		theBag.insert(s4);
		theBag.insert(s5);
		theBag.insert(s6);
		theBag.insert(s7);
		theBag.insert(s8);

		theBag.display();
		System.out.println(theBag.deletePersonById("3"));
		
	//	System.out.println(Major.CSE);

		/*
		 * Utilities.saveStudentArray("objects.dat", arr); 
		 * System.out.println("saved");
		 * Student[] myArray = Utilities.loadStudentArray("objects.dat");
		 * System.out.println(Arrays.toString(myArray));
		 */

	}

}
