package model;

import java.util.Arrays;

public class PersonBag {
	private Person[] arr;
	private int nElems;

	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
		nElems = 0;
	}

	public void insertStudent(String first, String last) {
		Person p = new Student(first, last, "outputData/Students.txt");
		arr[nElems++] = p;
	}
	
	public void insertStudent() {
		Person p = new Student("outputData/Students.txt");
		arr[nElems++] = p;
	}
	
	public void insert(Student s) {
		arr[nElems++] = s;
	}
	
	public void insertFaculty(String first, String last) {
		Person p2 = new Faculty(first, last, "outputData/Faculty.txt");
		arr[nElems++] = p2;
	}

	public void insertFaculty() {
		Person p2 = new Faculty("outputData/Faculty.txt");
		arr[nElems++] = p2;
	}
	
	public void insert(Faculty f) {
		arr[nElems++] = f;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
	}

	public Person[] getArr() {
		return arr;
	}

	public int getnElems() {
		return nElems;
	}

	@Override
	public String toString() {
		return "PersonBag [arr=" + Arrays.toString(arr) + ", nElems=" + nElems + "]";
	}
	
	
}
