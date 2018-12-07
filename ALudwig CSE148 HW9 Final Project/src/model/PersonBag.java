package model;

import java.io.Serializable;
import java.util.Arrays;

public class PersonBag implements Serializable{
	private Person[] arr;
	private int nElems;

	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
		nElems = 0;
	}

	public void insertStudent() {
		Person p = new Student("outputData/Students.txt");
		arr[nElems++] = p;
	}
	
	public void insert(Student s) {
		arr[nElems++] = s;
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

	public Person findById(String id) {
		for(int i = 0; i < nElems; i++) {
			if(arr[i].getId().equals(id)) {
				return arr[i];
			}
		}
		return null;
	}
	
	public Person deleteById(String id) {
		Person temp;
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(arr[i].getId().equals(id)) {
				break;
			}
		}
		if(i == nElems) {
			return null;
		} else {
			temp = arr[i];
			// the -1 prevents outofbounds if nElems=MaxSize
			for(int j = i; j < nElems - 1; j++) {
				arr[j] = arr[j + 1];
			}
			nElems--;
		}
		return temp;
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
