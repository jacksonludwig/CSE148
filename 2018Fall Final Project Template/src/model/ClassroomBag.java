package model;

import java.io.Serializable;

public class ClassroomBag implements Serializable{
	private Classroom[] array;
	private int nElems;

	public ClassroomBag(int maxSize) {
		array = new Classroom[maxSize];
		nElems = 0;
	}

	public void insert(Classroom classroom) {
		array[nElems++] = classroom;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Classroom findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (array[i].getRoomNumber().equals(id)) {
				return array[i];
			}
		}
		return null;
	}

	public Classroom removeById(String id) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (array[i].getRoomNumber().equals(id)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			Classroom temp = array[i];
			for (int j = i; j < nElems - 1; j++) {
				array[j] = array[j + 1];
			}
			nElems--;
			return temp;
		}
	}
}
