package sampleCode;

import java.io.Serializable;

public class StudentBag implements Serializable{
	private Student[] arr;
	private int nElems;

	public StudentBag(int maxSize) {
		arr = new Student[maxSize];
		nElems = 0;
	}

	public void insert(String name) {
		Student s = new Student(name);
		arr[nElems++] = s;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
	}

	public Student[] getArr() {
		return arr;
	}

	public int getnElems() {
		return nElems;
	}

}
